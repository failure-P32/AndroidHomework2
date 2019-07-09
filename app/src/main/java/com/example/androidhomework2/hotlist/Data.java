package com.example.androidhomework2.hotlist;

import java.util.ArrayList;
import java.util.List;

public class Data implements Comparable<Data> {

    public String text;
    public Integer hot;

    public Data(String str, int ht/*, String source*/) {
        text = str;
        hot = ht;
    }

    static private final String[] GAMELIST = {
            "Grand Theft Auto V", "Cyberpunk 2077", "Counter Strike: Global Offensive", "Dota 2",
            "Minecraft", "TotalWar: Three Kingdoms", "Civilization VI", "Assassin's Creed Odyssey",
            "Battlefield V", "Hearts of Iron IV", "PLAYERUNKNOWN'S BATTLEGROUND", "Watch_Dogs"
    };

    static List<Data> generateData() {
        List<Data> list = new ArrayList<>();
        for (int i = 0; i < GAMELIST.length ; i++) {
            list.add(new Data(GAMELIST[i], (GAMELIST.length - i) * 1000));
        }
        return list;
    }

    @Override
    public int compareTo(Data data) {
        return this.hot.compareTo(data.hot);
    }
}
