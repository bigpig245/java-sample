package anime.service;

import anime.dto.xemtivi.CategoryDto;
import anime.dto.xemtivi.MangaDto;
import anime.dto.xemtivi.ServerName;

import java.util.List;

public interface MangaService {
    List<CategoryDto> getCategories() throws Exception;

    List<MangaDto> getMangaList(CategoryDto categoryDto) throws Exception;

    void updateManga(MangaDto mangaDto) throws Exception;

    ServerName getServerName();
}
