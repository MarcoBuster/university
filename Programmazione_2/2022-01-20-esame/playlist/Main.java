package playlist;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final List<Album> albums = new LinkedList<>();
        final List<Playlist> playlists = new LinkedList<>();

        // read data
        final Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            final String headerLine = scanner.nextLine();

            // reading an ALBUM
            if (headerLine.startsWith("ALBUM")) {
                final String albumName = headerLine.replace("ALBUM", "").strip();
                List<String> songDurations = new LinkedList<>();
                List<String> songTitles = new LinkedList<>();
                // scan all songs
                while (scanner.hasNextLine()) {
                    final String line = scanner.nextLine();
                    if (line.equals("."))
                        break;

                    final String[] pieces = line.split("-");
                    songDurations.add(pieces[0].strip());
                    songTitles.add(pieces[1].strip());
                }
                // create album
                final Album album = new Album(albumName, songTitles, songDurations);
                albums.add(album);
            }
            // reading a PLAYLIST
            else if (headerLine.startsWith("PLAYLIST")) {
                final String playlistName = headerLine.replace("PLAYLIST", "").strip();
                final Playlist playlist = new Playlist(playlistName);
                // parse all indexes
                while (scanner.hasNextLine()) {
                    final String line = scanner.nextLine();
                    if (line.equals("."))
                        break;
                    final String[] pieces = line.split(" ");
                    final Integer albumIndex = Integer.parseInt(pieces[0]);
                    final Integer positionIndex = Integer.parseInt(pieces[1]);
                    playlist.aggiungi(albums.get(albumIndex-1).ottieniBrano(positionIndex));
                }
                playlists.add(playlist);
            }
        }
        scanner.close();

        // print all albums
        for (final Album album : albums)
            System.out.println(album.toString());
    
        // print all playlists
        for (final Playlist playlist : playlists)
            System.out.println(playlist.toString());

        // merge all playlists
        Playlist fusa = new Playlist("vuota");
        for (final Playlist playlist : playlists) {
            fusa = fusa.fondi(playlist, "Fusa");
        }

        // print merged playlist
        System.out.println(fusa.toString());

        // print albums of the merged playlist
        final List<Album> fusaAlbums = fusa.tuttiGliAlbum();
        for (final Album album : fusaAlbums) {
            System.out.println(album.nome);
            for (final Album.Brano song : fusa.braniDiAlbum(album)) {
                System.out.println(String.format("\t%s", song.toString()));
            }
        }
    }
}