package googleapi;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Iterator;

@Slf4j
public class SpreadsheetTest {
    private static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static HttpTransport httpTransport;
    private static final String FILE_BUNDLES_ID = "1LFfWMF7P66ULbTFdM3tZLiyKTedJUnOK4UZPVsJ48Jc";
    private static String downloadRoot;
    private static String targetPath;

    private static final String CLIENT_SECRET_DIR = "/client_secret.json";

    static {
        try {
            httpTransport = GoogleNetHttpTransport.newTrustedTransport();
            File targetClassesDir = new File(SpreadsheetTest.class
                    .getProtectionDomain().getCodeSource().getLocation().getPath());
            targetPath = targetClassesDir.getParentFile().getPath();
            downloadRoot = targetPath + File.separator + "generated-resources/download";

            //Create Directory i18n if not exit
            java.io.File i18nDir = new java.io.File(downloadRoot);

            if (!i18nDir.exists()) {
                i18nDir.mkdirs();
            }
        } catch (Throwable t) {
            log.error("Error when create a trusted trasport to google drive", t);
        }
    }


    /**
     * Prints the names and majors of students in a sample spreadsheet:
     * https://docs.google.com/spreadsheets/d/1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms/edit
     */
    public static void main(String... args) throws IOException, GeneralSecurityException {
        generateBundle(getDriveService());
    }


    public static void generateBundle(Drive service) throws IOException {

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            // Get The Bundles from Drive with Id

            service.files().export(FILE_BUNDLES_ID, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
                    .executeMediaAndDownloadTo(outputStream);


            java.io.File bundleDonwloadedFile = new java.io.File(downloadRoot + File.separator + "downloaded_spreadsheet.xlsx");
            try (FileOutputStream fileOutputStream = new FileOutputStream(bundleDonwloadedFile)) {
                outputStream.writeTo(fileOutputStream);
            }

            log.info("---- Download Bundles Complete");
            Sheet datatypeSheet;
            try (FileInputStream excelFile = new FileInputStream(bundleDonwloadedFile)) {
                Workbook workbook = new XSSFWorkbook(excelFile);
                datatypeSheet = workbook.getSheetAt(0);
            }

            processSheet(datatypeSheet);

            //delete bundles file from target
            //bundleDonwloadedFile.delete();

        }
    }

    private static void processSheet(Sheet datatypeSheet) {

        Iterator<Row> iterator = datatypeSheet.iterator();
        while (iterator.hasNext()) {

            Row currentRow = iterator.next();
            Iterator<Cell> cellIterator = currentRow.iterator();

            while (cellIterator.hasNext()) {

                Cell currentCell = cellIterator.next();

                if (currentCell.getCellTypeEnum() == CellType.STRING) {
                    System.out.println(currentCell.getStringCellValue());
                } else {
                    log.error("Wrong type expected String but found {}", currentCell.getCellTypeEnum());
                }

            }
            break;
        }
    }

    /**
     * Creates an authorized Credential object.
     *
     * @return an authorized Credential object.
     * @throws IOException
     */
    public static Credential authorize() throws IOException {

        // Load client secrets.
        try (InputStream in = SpreadsheetTest.class.getResourceAsStream(CLIENT_SECRET_DIR)) {
            GoogleCredential credential = GoogleCredential.fromStream(in)
                    .createScoped(Collections.singleton(DriveScopes.DRIVE_READONLY));
            return credential;
        }
    }

    /**
     * Build and return an authorized Drive client service.
     *
     * @return an authorized Drive client service
     * @throws IOException
     */
    public static Drive getDriveService() throws IOException {
        Credential credential = authorize();
        return new Drive.Builder(
                httpTransport, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }


}
