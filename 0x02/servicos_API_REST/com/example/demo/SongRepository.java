package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

@Repository
public class SongRepository {
	private List<Song> list = new ArrayList<Song>();

	public SongRepository() {
		var song1 = new Song(1, "Bohemian Rhapsody", "Queen", "A Night at the Opera", "1975");
		var song2 = new Song(2, "Imagine", "John Lennon", "Imagine", "1971");
		list.add(song1);
		list.add(song2);
	}

	public List<Song> getAllSongs() {
		return list;
	}

	public Song getSongById(Integer id) {
		return list.stream().filter(obj -> obj.getId() == id).findFirst().get();
	}

	public void addSong(Song s) {
		list.add(s);
	}

	public void updateSong(Song s) {
		list.stream().filter(obj -> obj.getId() == s.getId())
		.findFirst()
		.ifPresent(obj -> {
			obj.setAlbum(s.getAlbum());
			obj.setAnoLancamento(s.getAnoLancamento());
			obj.setArtista(s.getArtista());
			obj.setNome(s.getNome());
		});
	}

	public void removeSong(Song s) {
		this.list = list.stream()
				.filter(obj -> obj.getId() != s.getId()).collect(Collectors.toList());
	}
}