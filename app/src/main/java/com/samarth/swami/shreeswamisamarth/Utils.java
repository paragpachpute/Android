package com.samarth.swami.shreeswamisamarth;

/**
 * Created by Ashish on 22-07-2015.
 */
public class Utils {
    public static final String EXTRA_POSITION = "position";
    public static final int STATE_PLAYING = 1;

    int songsArray[];
    String nameArray[];
    int count;
    Utils(){
        count = 1;
        songsArray = new int[count];
        int pos = -1;
        nameArray = new String[count];

        pos++;
        songsArray[pos] = R.raw.narayani_guru_mauli;
        nameArray[pos] = "Narayani Guru Mauli";

        /*
        pos++;
        songsArray[pos] = R.raw.mauli_mi_tuzi_karuna;
        nameArray[pos] = "Mauli Mi Tuzi Karuna";
        pos++;
        songsArray[pos] = R.raw.pradakshina_ghalu_aaudumbara;
        nameArray[pos] = "Pradakshina Ghalu Aaudumbara";
        pos++;
        songsArray[pos] = R.raw.shamal_komal_pavan_shital;
        nameArray[pos] = "Shamal Konal Pavan Shital";
        pos++;
        songsArray[pos] = R.raw.vithu_mauli;
        nameArray[pos] = "Vithu Mauli";
        pos++;
        songsArray[pos] = R.raw.akkalkot_swami;
        nameArray[pos] = "Akkalkot Swami";
        pos++;
        songsArray[pos] = R.raw.swami_tuzya_namane;
        nameArray[pos] = "Swami Tuzya Namane";
        pos++;
        songsArray[pos] = R.raw.prarthana;
        nameArray[pos] = "Prarthana";
        pos++;
        songsArray[pos] = R.raw.jap;
        nameArray[pos] = "Jap";*/
    }
    int getSong(int position){
        return songsArray[position];
    }
    String getName(int position){
        return nameArray[position];
    }
}
