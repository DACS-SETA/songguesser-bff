package com.songguesser.bff.api.client;

import java.util.List;

import com.songguesser.bff.dto.SongDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
		name = "apiConectorClient", 
		url = "${feign.client.config.apiconectorclient.url}"
		)
public interface ApiConectorClient {

        @GetMapping("/itunes/random")
        SongDto getRandomSong();

        @GetMapping("/itunes/artist/{artist}")
        List<SongDto> getSongsByArtist(@PathVariable("artist") String artist);

        @GetMapping("/itunes/genre/{genre}")
        SongDto getRandomByGenre(@PathVariable("genre") String genre);

        @GetMapping("/itunes/search")
        List<SongDto> searchSongs(@RequestParam("term") String query);
}
