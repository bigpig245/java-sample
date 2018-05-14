package anime.utils;

import anime.dto.UrlBaseDto;
import lombok.experimental.UtilityClass;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@UtilityClass
public class URLUtils {

    public List<UrlBaseDto> retrieveCategory(String url, String filter) throws IOException {
        Document doc = Jsoup.connect(url).get();

        String cssQuery = String.format("div[class=%s", filter);
        //contains

        Elements links = doc.select(cssQuery); // a with href
        List<UrlBaseDto> list = new ArrayList<>();

        links.forEach(link -> list.add(buildUrlDto(link)));
        return list;
    }

    public List<UrlBaseDto> readContent(String url, String filter) throws IOException {
        Document doc = Jsoup.connect(url).get();

        String cssQuery = String.format("a[href*=%s", filter);
        //contains

        Elements links = doc.select(cssQuery); // a with href
        List<UrlBaseDto> list = new ArrayList<>();

        links.forEach(link -> list.add(buildUrlDto(link)));
        return list;
    }

    public Map<String, List<UrlBaseDto>> readContentByMap(String url, String filter) throws IOException {
        List<UrlBaseDto> list = readContent(url, filter);

        return list.stream().collect(Collectors.groupingBy(UrlBaseDto::getServerName));
    }

    private UrlBaseDto buildUrlDto(Element element) {
        return UrlBaseDto.builder()
                .href(element.attr("href"))
                .className(element.attr("class"))
                .title(element.attr("title"))
                .content(element.text())
                .serverName(element.parent().previousElementSibling().text())
                .build();
    }
}
