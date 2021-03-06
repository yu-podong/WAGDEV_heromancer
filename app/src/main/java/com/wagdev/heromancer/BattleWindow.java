package com.wagdev.heromancer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;


public class BattleWindow {
    private ImageButton[] mob=new ImageButton[5];
    private ImageButton[] player=new ImageButton[3];
    private Button backbtn;

    private ImageView[] now_turn=new ImageView[3];

    private ProgressBar[] mobhp=new ProgressBar[5];
    private ProgressBar[] playerhp=new ProgressBar[3];
    private ProgressBar playermp;


    private int mobNum;
    private int playerNum;
    private ConstraintLayout layout;
    private Context context;
    private clickevent c;
    public BattleWindow(ConstraintLayout l, Context con, int playerNum, int mobNum, clickevent c){
        this.layout=l;
        this.context=con;
        this.playerNum=playerNum;
        this.mobNum=mobNum;
        this.c=c;

        backbtn=(Button)layout.findViewById(R.id.backbutton);
        backbtn.setOnClickListener(c.backbtn);
        backbtn.setVisibility(View.INVISIBLE);

        //자주 사용되기에 미리 찾아둠
        mob[0]=(ImageButton)layout.findViewById(R.id.mob1);
        mob[1]=(ImageButton)layout.findViewById(R.id.mob2);
        mob[2]=(ImageButton)layout.findViewById(R.id.mob3);
        mob[3]=(ImageButton)layout.findViewById(R.id.mob4);
        mob[4]=(ImageButton)layout.findViewById(R.id.mob5);
        player[0]=(ImageButton)layout.findViewById(R.id.player1);
        player[1]=(ImageButton)layout.findViewById(R.id.player2);
        player[2]=(ImageButton)layout.findViewById(R.id.player3);


        now_turn[0]=(ImageView)layout.findViewById(R.id.p1);
        now_turn[1]=(ImageView)layout.findViewById(R.id.p2);
        now_turn[2]=(ImageView)layout.findViewById(R.id.p3);

        for(int i=1;i<3;i++){
            now_turn[i].setVisibility(View.INVISIBLE);
        }

        mobhp[0]=(ProgressBar)layout.findViewById(R.id.mob1hp);
        mobhp[1]=(ProgressBar)layout.findViewById(R.id.mob2hp);
        mobhp[2]=(ProgressBar)layout.findViewById(R.id.mob3hp);
        mobhp[3]=(ProgressBar)layout.findViewById(R.id.mob4hp);
        mobhp[4]=(ProgressBar)layout.findViewById(R.id.mob5hp);
        playerhp[0]=(ProgressBar)layout.findViewById(R.id.playerhp1);
        playerhp[1]=(ProgressBar)layout.findViewById(R.id.playerhp2);
        playerhp[2]=(ProgressBar)layout.findViewById(R.id.playerhp3);
        //주인공 mp
        playermp=(ProgressBar)layout.findViewById(R.id.playermp1);


        //리스너 등록
        for (int i=0;i<mobNum;i++) {
            mob[i].setOnClickListener(c.mob);
        }
        for (int i=0;i<playerNum;i++) {
            player[i].setOnClickListener(c.player);
        }




    }

    public void setBackbtn(int v){
        backbtn.setVisibility(v);
    }

    public void setnowturn(int target,boolean on){
        if(on)
            now_turn[target].setVisibility(View.VISIBLE);
        else
            now_turn[target].setVisibility(View.INVISIBLE);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void select_mob(Drawable d, int i){
        /*mob1이 0*/
        c.setMobtarget(true);
        mob[i].setForeground(d);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void finish_select_mob(int i){
        c.setMobtarget(false);
        mob[i].setForeground(null);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void select_player(Drawable d, int i){
        /*player1이 0*/
        c.setPlayertarget(true);
        player[i].setForeground(d);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void finish_select_player(int i){
        c.setPlayertarget(false);
        player[i].setForeground(null);
    }

    public void mobdie(int i,int image){
        mob[i].setImageResource(image);
    }

    public void playerdie(int i,int image){
        player[i].setImageResource(image);
    }

    public void setmobHP(int target,int per){
        mobhp[target].setProgress(per);
    }

    public void setplayerHP(int target,int per){
        playerhp[target].setProgress(per);
    }

    public void setplayerMP(int per){
        playermp.setProgress(per);
    }

    public void setmobimage(int i,int image){
        mob[i].setImageResource(image);
    }

    public void setPlayerimage(int i,int image){
        player[i].setImageResource(image);
    }

    public void setmobVisibility(int i,int v){
        mob[i].setVisibility(v);
        mobhp[i].setVisibility(v);
    }
    public void setplayerVisibility(int i,int v){
        player[i].setVisibility(v);
        playerhp[i].setVisibility(v);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setforeground(Drawable d){
        layout.setForeground(d);
    }

    //디버기을 위한함수
    /*//private int testcount=0;
    public void test(String a){
        //testcount++;
        ((TextView)layout.findViewById(R.id.test)).setText(a);
    }*/

}
