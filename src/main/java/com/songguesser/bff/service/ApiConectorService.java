package com.songguesser.bff.service;

import com.songguesser.bff.dto.SongDto;

import java.util.List;

public interface ApiConectorService {

    SongDto getRandomSong();

    List<SongDto> getSongsByArtist(String artist);

    SongDto getRandomByGenre(String genre);

    List<SongDto> searchSongs(String term);


}
