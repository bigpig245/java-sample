package anime.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UrlBaseDto {
    String href;
    String title;
    String className;
    String content;
    String serverName;

    /**
     * <a class="" href="http://xemvtv.net/xem-phim/dao-hai-tac-tap-29/I6OUII.html" title="Xem phim Đảo Hải Tặc tập 29">29</a>
     */
}
