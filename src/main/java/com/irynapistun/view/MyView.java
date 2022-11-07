package com.irynapistun.view;

import com.irynapistun.controller.*;
import com.irynapistun.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MyView {

    @Autowired
    private AlbumController albumController;
    @Autowired
    private GenreController genreController;
    @Autowired
    private MusicalLabelController musicalLabelController;
    @Autowired
    private MusicianController musicianController;
    @Autowired
    private PlaylistController playlistController;
    @Autowired
    private SongController songController;
    @Autowired
    private UserController userController;

    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private final Scanner input = new Scanner(System.in);
    private final Album nullAlbum = new Album(null, null, null, null);
    private final Genre nullGenre = new Genre(null, null);
    private final MusicalLabel nullMusicalLabel = new MusicalLabel(null, null);
    private final Musician nullMusician = new Musician(null, null, null, null);
    private final Playlist nullPlaylist = new Playlist(null, null);
    private final Song nullSong = new Song(null, null, null, null, null);
    private final User nullUser = new User(null, null, null, null);

    public MyView() {
        menu = new LinkedHashMap<>();
        menu.put("A", "  A - Select all table");

        menu.put("1", "   1 - Table: Album");
        menu.put("11", "  11 - Create Album");
        menu.put("12", "  12 - Update Album");
        menu.put("13", "  13 - Delete from Album");
        menu.put("14", "  14 - Find all Albums");
        menu.put("15", "  15 - Find Album by ID");
        menu.put("16", "  16 - Find Album by album_name");

        menu.put("2", "   2 - Table: Genre");
        menu.put("21", "  21 - Create Genre");
        menu.put("22", "  22 - Update Genre");
        menu.put("23", "  23 - Delete from Genre");
        menu.put("24", "  24 - Find all Genres");
        menu.put("25", "  25 - Find Genre by ID");
        menu.put("26", "  26 - Find Genre by genre_name");

        menu.put("3", "   3 - Table: MusicalLabel");
        menu.put("31", "  31 - Create MusicalLabel");
        menu.put("32", "  32 - Update MusicalLabel");
        menu.put("33", "  33 - Delete from MusicalLabel");
        menu.put("34", "  34 - Find all MusicalLabels");
        menu.put("35", "  35 - Find MusicalLabel by ID");
        menu.put("36", "  36 - Find MusicalLabel by musicalLabel_name");

        menu.put("4", "   4 - Table: Musician");
        menu.put("41", "  41 - Create Musician");
        menu.put("42", "  42 - Update Musician");
        menu.put("43", "  43 - Delete from Musician");
        menu.put("44", "  44 - Find all Musician");
        menu.put("45", "  45 - Find Musician by ID");
        menu.put("46", "  46 - Find Musician by musician_firstName");
        menu.put("47", "  47 - Find Musician by musician_lastName");

        menu.put("5", "   5 - Table: Playlist");
        menu.put("51", "  51 - Create Playlist");
        menu.put("52", "  52 - Update Playlist");
        menu.put("53", "  53 - Delete from Playlist");
        menu.put("54", "  54 - Find all Playlist");
        menu.put("55", "  55 - Find Playlist by ID");

        menu.put("6", "   6 - Table: Song");
        menu.put("61", "  61 - Create Song");
        menu.put("62", "  62 - Update Song");
        menu.put("63", "  63 - Delete from Song");
        menu.put("64", "  64 - Find all Song");
        menu.put("65", "  65 - Find Song by ID");
        menu.put("66", "  66 - Find Song by song_name");

        menu.put("7", "   7 - Table: User");
        menu.put("71", "  71 - Create User");
        menu.put("72", "  72 - Update User");
        menu.put("73", "  73 - Delete from User");
        menu.put("74", "  74 - Find all User");
        menu.put("75", "  75 - Find User by ID");
        menu.put("76", "  76 - Find User by user_firstName");
        menu.put("77", "  77 - Find User by user_lastName");

        menu.put("Q", "  Q - exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("A", this::selectAllTable);

        methodsMenu.put("11", this::createAlbum);
        methodsMenu.put("12", this::updateAlbum);
        methodsMenu.put("13", this::deleteFromAlbum);
        methodsMenu.put("14", this::findAllAlbums);
        methodsMenu.put("15", this::findAlbumById);
        methodsMenu.put("16", this::findAlbumByAlbumName);

        methodsMenu.put("21", this::createGenre);
        methodsMenu.put("22", this::updateGenre);
        methodsMenu.put("23", this::deleteFromGenre);
        methodsMenu.put("24", this::findAllGenres);
        methodsMenu.put("25", this::findGenreById);
        methodsMenu.put("26", this::findGenreByGenreName);

        methodsMenu.put("31", this::createMusicalLabel);
        methodsMenu.put("32", this::updateMusicalLabel);
        methodsMenu.put("33", this::deleteFromMusicalLabel);
        methodsMenu.put("34", this::findAllMusicalLabels);
        methodsMenu.put("35", this::findMusicalLabelById);
        methodsMenu.put("36", this::findMusicalLabelByMusicalLabelName);

        methodsMenu.put("41", this::createMusician);
        methodsMenu.put("42", this::updateMusician);
        methodsMenu.put("43", this::deleteFromMusician);
        methodsMenu.put("44", this::findAllMusicians);
        methodsMenu.put("45", this::findMusicianById);
        methodsMenu.put("46", this::findMusicianByMusicianFirstName);
        methodsMenu.put("47", this::findMusicianByMusicianLastName);

        methodsMenu.put("51", this::createPlaylist);
        methodsMenu.put("52", this::updatePlaylist);
        methodsMenu.put("53", this::deleteFromPlaylist);
        methodsMenu.put("54", this::findAllPlaylists);
        methodsMenu.put("55", this::findPlaylistById);

        methodsMenu.put("61", this::createSong);
        methodsMenu.put("62", this::updateSong);
        methodsMenu.put("63", this::deleteFromSong);
        methodsMenu.put("64", this::findAllSongs);
        methodsMenu.put("65", this::findSongById);
        methodsMenu.put("66", this::findSongBySongName);

        methodsMenu.put("71", this::createUser);
        methodsMenu.put("72", this::updateUser);
        methodsMenu.put("73", this::deleteFromUser);
        methodsMenu.put("74", this::findAllUsers);
        methodsMenu.put("75", this::findUserById);
        methodsMenu.put("76", this::findUserByUserFirstName);
        methodsMenu.put("77", this::findUserByUserLastName);
    }

    private void selectAllTable() {
        findAllAlbums();
        findAllGenres();
        findAllMusicalLabels();
        findAllMusicians();
        findAllPlaylists();
        findAllSongs();
        findAllUsers();
    }

    // region BOOK ---------------------------------------------------
    private void createAlbum() {
        System.out.println("Input 'album_name': ");
        String name = input.nextLine();
        System.out.println("Input 'year_of_publishing': ");
        Integer yearOfPublishing = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'album musicalLabelId': ");
        Integer musicalLabelId = Integer.valueOf((input.nextLine()));
        Album album = new Album(null, name, yearOfPublishing, musicalLabelId);

        int count = albumController.create(album);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateAlbum() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'album_name': ");
        String newName = input.nextLine();
        System.out.println("Input New 'year_of_publishing': ");
        Integer yearOfPublishing = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'album musicalLabelId': ");
        Integer musicalLabelId = Integer.valueOf((input.nextLine()));
        Album album = new Album(null, newName, yearOfPublishing, musicalLabelId);

        int count = albumController.update(id, album);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromAlbum() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = albumController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllAlbums() {
        System.out.println("\nTable: ALBUM");
        List<Album> albums = albumController.findAll();
        for (Album album : albums) {
            System.out.println(album);
        }
    }

    private void findAlbumById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Album> album = albumController.findById(id);
        System.out.println(album.orElse(nullAlbum));
    }

    private void findAlbumByAlbumName() {
        System.out.println("Input 'album_name': ");
        String name = input.nextLine();

        Optional<Album> album = albumController.findByAlbumName(name);
        System.out.println(album.orElse(nullAlbum));
    }

    private void createGenre() {
        System.out.println("Input 'genre_name': ");
        String name = input.nextLine();
        Genre genre = new Genre(null, name);

        int count = genreController.create(genre);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateGenre() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        System.out.println("Input new 'genre_name': ");
        String newName = input.nextLine();
        Genre genre = new Genre(null, newName);

        int count = genreController.update(id, genre);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromGenre() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = genreController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllGenres() {
        System.out.println("\nTable: GENRE");
        List<Genre> genres = genreController.findAll();
        for (Genre genre : genres) {
            System.out.println(genre);
        }
    }

    private void findGenreById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Genre> genre = genreController.findById(id);
        System.out.println(genre.orElse(nullGenre));
    }

    private void findGenreByGenreName() {
        System.out.println("Input 'genre_name': ");
        String name = input.nextLine();

        Optional<Genre> genre = genreController.findByGenreName(name);
        System.out.println(genre.orElse(nullGenre));
    }

    private void createMusicalLabel() {
        System.out.println("Input 'musicalLabel_name': ");
        String name = input.nextLine();
        MusicalLabel musicalLabel = new MusicalLabel(null, name);

        int count = musicalLabelController.create(musicalLabel);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateMusicalLabel() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        System.out.println("Input new 'musicalLabel_name': ");
        String newName = input.nextLine();
        MusicalLabel musicalLabel = new MusicalLabel(null, newName);

        int count = musicalLabelController.update(id, musicalLabel);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromMusicalLabel() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = musicalLabelController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllMusicalLabels() {
        System.out.println("\nTable: MUSICAL_LABEL");
        List<MusicalLabel> musicalLabels = musicalLabelController.findAll();
        for (MusicalLabel musicalLabel : musicalLabels) {
            System.out.println(musicalLabel);
        }
    }

    private void findMusicalLabelById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<MusicalLabel> musicalLabel = musicalLabelController.findById(id);
        System.out.println(musicalLabel.orElse(nullMusicalLabel));
    }

    private void findMusicalLabelByMusicalLabelName() {
        System.out.println("Input 'musicalLabel_name': ");
        String name = input.nextLine();

        Optional<MusicalLabel> musicalLabel = musicalLabelController.findByMusicalLabelName(name);
        System.out.println(musicalLabel.orElse(nullMusicalLabel));
    }

    private void createMusician() {
        System.out.println("Input 'first_name': ");
        String firstName = input.nextLine();
        System.out.println("Input 'last_name': ");
        String lastName = input.nextLine();
        System.out.println("Input 'musician albumId': ");
        Integer albumId = Integer.valueOf((input.nextLine()));
        Musician musician = new Musician(null, firstName, lastName, albumId);

        int count = musicianController.create(musician);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateMusician() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        System.out.println("Input new 'first_name': ");
        String newFirstName = input.nextLine();
        System.out.println("Input new 'last_name': ");
        String newLastName = input.nextLine();
        System.out.println("Input 'musician albumId': ");
        Integer albumId = Integer.valueOf((input.nextLine()));
        Musician musician = new Musician(null, newFirstName, newLastName, albumId);

        int count = musicianController.update(id, musician);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromMusician() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = musicianController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllMusicians() {
        System.out.println("\nTable: MUSICIAN");
        List<Musician> musicians = musicianController.findAll();
        for (Musician musician : musicians) {
            System.out.println(musician);
        }
    }

    private void findMusicianById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Musician> musician = musicianController.findById(id);
        System.out.println(musician.orElse(nullMusician));
    }

    private void findMusicianByMusicianFirstName() {
        System.out.println("Input 'first_name': ");
        String firstName = input.nextLine();

        Optional<Musician> musician = musicianController.findByFirstName(firstName);
        System.out.println(musician.orElse(nullMusician));
    }

    private void findMusicianByMusicianLastName() {
        System.out.println("Input 'last_name': ");
        String lastName = input.nextLine();

        Optional<Musician> musician = musicianController.findByLastName(lastName);
        System.out.println(musician.orElse(nullMusician));
    }

    private void createPlaylist() {
        System.out.println("Input 'number_of_songs': ");
        Integer numberOfSongs = Integer.valueOf((input.nextLine()));
        Playlist playlist = new Playlist(null, numberOfSongs);

        int count = playlistController.create(playlist);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updatePlaylist() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'new_number_of_songs': ");
        Integer newNumberOfSongs = Integer.valueOf((input.nextLine()));
        Playlist playlist = new Playlist(null, newNumberOfSongs);

        int count = playlistController.update(id, playlist);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromPlaylist() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = playlistController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllPlaylists() {
        System.out.println("\nTable: PLAYLIST");
        List<Playlist> playlists = playlistController.findAll();
        for (Playlist playlist : playlists) {
            System.out.println(playlist);
        }
    }

    private void findPlaylistById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Playlist> playlist = playlistController.findById(id);
        System.out.println(playlist.orElse(nullPlaylist));
    }

    private void createSong() {
        System.out.println("Input 'song_name': ");
        String name = input.nextLine();
        System.out.println("Input 'duration': ");
        Double duration = Double.valueOf((input.nextLine()));
        System.out.println("Input 'song albumId': ");
        Integer albumId = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'song genreId': ");
        Integer genreId = Integer.valueOf((input.nextLine()));
        Song song = new Song(null, duration, name, albumId, genreId);

        int count = songController.create(song);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateSong() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'new_song_name': ");
        String newName = input.nextLine();
        System.out.println("Input 'new_duration': ");
        Double newDuration = Double.valueOf((input.nextLine()));
        System.out.println("Input 'song albumId': ");
        Integer albumId = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'song genreId': ");
        Integer genreId = Integer.valueOf((input.nextLine()));
        Song song = new Song(null, newDuration, newName, albumId, genreId);

        int count = songController.update(id, song);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromSong() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = songController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllSongs() {
        System.out.println("\nTable: SONG");
        List<Song> songs = songController.findAll();
        for (Song song : songs) {
            System.out.println(song);
        }
    }

    private void findSongById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Song> song = songController.findById(id);
        System.out.println(song.orElse(nullSong));
    }

    private void findSongBySongName() {
        System.out.println("Input 'song_name': ");
        String name = input.nextLine();

        Optional<Song> song = songController.findBySongName(name);
        System.out.println(song.orElse(nullSong));
    }

    private void createUser() {
        System.out.println("Input 'first_name': ");
        String firstName = input.nextLine();
        System.out.println("Input 'last_name': ");
        String lastName = input.nextLine();
        System.out.println("Input 'user playlistId': ");
        Integer playlistId = Integer.valueOf((input.nextLine()));
        User user = new User(null, firstName, lastName, playlistId);

        int count = userController.create(user);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateUser() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        System.out.println("Input new 'first_name': ");
        String newFirstName = input.nextLine();
        System.out.println("Input new 'last_name': ");
        String newLastName = input.nextLine();
        System.out.println("Input 'user playlistId': ");
        Integer playlistId = Integer.valueOf((input.nextLine()));
        User user = new User(null, newFirstName, newLastName, playlistId);

        int count = userController.update(id, user);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromUser() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = userController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllUsers() {
        System.out.println("\nTable: USER");
        List<User> users = userController.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    private void findUserById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<User> user = userController.findById(id);
        System.out.println(user.orElse(nullUser));
    }

    private void findUserByUserFirstName() {
        System.out.println("Input 'first_name': ");
        String firstName = input.nextLine();

        Optional<User> user = userController.findByFirstName(firstName);
        System.out.println(user.orElse(nullUser));
    }

    private void findUserByUserLastName() {
        System.out.println("Input 'last_name': ");
        String lastName = input.nextLine();

        Optional<User> user = userController.findByLastName(lastName);
        System.out.println(user.orElse(nullUser));
    }

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet())
            if (key.length() == 1) System.out.println(menu.get(key));
    }

    private void outputSubMenu(String fig) {

        System.out.println("\nSubMENU:");
        for (String key : menu.keySet())
            if (key.length() != 1 && key.substring(0, 1).equals(fig)) System.out.println(menu.get(key));
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point.");
                keyMenu = input.nextLine().toUpperCase();
            }

            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!keyMenu.equals("Q"));
    }
}

