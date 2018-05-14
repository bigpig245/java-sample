package common;

import anime.Constants;
import anime.dto.UrlBaseDto;
import anime.utils.URLUtils;

import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws Exception {
        String filter = String.format("%s%s%s", Constants.XEM_VTV_MAIN_URL, Constants.XEM_VTV_VIEW_URL, "dao-hai-tac-tap");
        Map<String, List<UrlBaseDto>> map = URLUtils.readContentByMap("http://xemvtv.net/xem-phim/dao-hai-tac-tap-586/I6WWU6.html", filter);
        System.out.println(map.keySet());

    }

}
