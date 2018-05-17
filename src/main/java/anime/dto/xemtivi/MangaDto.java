package anime.dto.xemtivi;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MangaDto {
    int no;
    String name;
    String title;
    String path;
    String description;
    String coverPage;
    List<ChapterDto> chapterDtos;
    List<CategoryDto> categoryDtos;
    int chapterNumber;
    int views;
    int commentNumber;
    boolean favorite;

    public void print(){
        System.out.println("\t==================================");
        System.out.println("\tName: " + name);
        System.out.println("\tTitle: " + title);
        System.out.println("\tPath: " + path);
        System.out.println("\tDescription: " + description);
        System.out.println("\tCover Page: " + coverPage);
        System.out.println("\tChapters: ");
        for(ChapterDto chapterDto: chapterDtos){
            System.out.println("\t\t" + chapterDto.getName());
        }

        System.out.println("\tCategories: ");
        for(CategoryDto categoryDto: categoryDtos){
            System.out.println("\t\t" + categoryDto.getName());
        }
    }
}
