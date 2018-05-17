package anime.dto.xemtivi;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ServerName {
    BLOGTRUYEN("blog truyen", "http://blogtruyen.com/");

    String name;
    String url;
}
