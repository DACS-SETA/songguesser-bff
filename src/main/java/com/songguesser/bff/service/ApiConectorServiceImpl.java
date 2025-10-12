package com.songguesser.bff.service;

import java.util.List;

import com.songguesser.bff.dto.SongDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songguesser.bff.api.client.ApiConectorClient;

@Service
public class ApiConectorServiceImpl implements ApiConectorService {

	@Autowired
	private ApiConectorClient apiConectorClient;

    @Override
    public SongDto getRandomSong() {
        return apiConectorClient.getRandomSong();
    }

    @Override
    public List<SongDto> getSongsByArtist(String artist) {
        return apiConectorClient.getSongsByArtist(artist);
    }

    @Override
    public SongDto getRandomByGenre(String genre) {
        return apiConectorClient.getRandomByGenre(genre);
    }

    @Override
    public List<SongDto> searchSongs(String term) {
        return apiConectorClient.searchSongs(term);
    }

}
