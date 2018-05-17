package common;

import anime.Constants;
import anime.dto.UrlBaseDto;
import anime.dto.xemtivi.CategoryDto;
import anime.dto.xemtivi.MangaDto;
import anime.service.BlogTruyenMangaService;
import anime.utils.URLUtils;
import com.google.common.base.CharMatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws Exception {
        String filter = String.format("%s%s%s", Constants.XEM_VTV_MAIN_URL, Constants.XEM_VTV_VIEW_URL, "dao-hai-tac-tap");
        Map<String, List<UrlBaseDto>> map = URLUtils.readContentByMap("http://xemvtv.net/xem-phim/dao-hai-tac-tap-586/I6WWU6.html", filter);
        System.out.println(map.keySet());
        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }

        BlogTruyenMangaService blogTruyenMangaService = new BlogTruyenMangaService();
        List<CategoryDto> categoryDtos = blogTruyenMangaService.getCategories();
        for (CategoryDto categoryDto : categoryDtos) {
            categoryDto.print();
            List<MangaDto> mangaDtos = blogTruyenMangaService.getMangaList(categoryDto);
            for (MangaDto mangaDto : mangaDtos) {
                blogTruyenMangaService.updateManga(mangaDto);
                mangaDto.print();
            }
        }

        String s = "javascript:LoadMangaPage(16)";
        System.out.println(CharMatcher.DIGIT.retainFrom(s));

    }

}
