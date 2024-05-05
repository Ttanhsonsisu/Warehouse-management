package org.example.view.login_register.forms;

import jakarta.persistence.EntityManager;
import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Home extends JPanel {

    private List<ModelLocation> locations;

    private int index = 0;

    private MediaPlayerFactory factory;

    private EmbeddedMediaPlayer mediaPlayer;

    private HomeOverlay homeOverlay;

    private final EntityManager em;

    public Home(EntityManager em) {
        this.em = em;
        init();
        testData();
    }

    private void init() {
        factory = new MediaPlayerFactory();
        mediaPlayer = factory.mediaPlayers().newEmbeddedMediaPlayer();
        Canvas canvas = new Canvas();
        mediaPlayer.videoSurface().set(factory.videoSurfaces().newVideoSurface(canvas));
        // lặp lại khi video kết thúc "đa phương tiện"
        mediaPlayer.events().addMediaPlayerEventListener(new MediaPlayerEventAdapter() {
            @Override
            public void timeChanged(MediaPlayer mediaPlayer, long newTime) {
                if(newTime >= mediaPlayer.status().length()-1000) { // lap lai truoc 1 giay truoc khi end
                    mediaPlayer.controls().setPosition(0);
                }
            }
        });

        setLayout(new BorderLayout());
        add(canvas);
    }

    private void testData() {
        locations = new ArrayList<>();
        locations.add(new ModelLocation("tile\nRetreat",
                "tes",
                "videos/video3.mp4"));

        locations.add(new ModelLocation("Whispering Pines\nRetreat",
                "tesst2" ,
                "videos/video2.mp4"));

        locations.add(new ModelLocation("title\nResort",
                "ntesst3",
                "videos/video11.mp4"));

    }

    public void initOverlay(JFrame frame) {
           homeOverlay = new HomeOverlay(frame, locations, em);
           homeOverlay.getOverlay().setEventHomeOverlay(index1 -> {
               play(index1);
           });
           mediaPlayer.overlay().set(homeOverlay);
           mediaPlayer.overlay().enable(true);
    }

    public void play(int index) {
        this.index = index;
        ModelLocation location = locations.get(index);

        if(mediaPlayer.status().isPlaying()) {
            mediaPlayer.controls().stop();
        }
        mediaPlayer.media().play(location.getVideoPath());
        homeOverlay.getOverlay().setIndex(index);
    }

    public void stop() {
        mediaPlayer.controls().stop();
        mediaPlayer.release();
        factory.release();
    }
}
