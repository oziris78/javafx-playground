package com.twistral.apps.cookieclicker;

import com.twistral.Main;
import com.twistral.toriafx.TScene;
import com.twistral.toriafx.ToriaFX;
import javafx.scene.effect.Bloom;
import javafx.scene.image.*;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.media.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;


class CookieClickerScene extends TScene<CookieClickerApplication, AnchorPane> {

    private ImageView iviewCookie;
    private Text textRight, textLeft;
    private Text textCookieStand, textCookiePistol, textCookieSlave, textCookieBakery, textCookieGun,
            textCookieTree, textCookieFarm, textCookieThief, textCookieBank, textCookieChef, textCookieCEO,
            textCookieFactory, textNatosCookieStash, textGodsCookieStash, textGrandmasStash;
    private Text[] textsFirst, textsSecond, textsThird;
    private Text textCookies, textClick, textIncome;
    private TextFlow textFlowStats;
    private VBox paneText;
    private Text textStatName, textStatCost, textStatClick, textStatIncome;

    private MediaPlayer mplayerCookie, mplayerButton;
    private int currentPage = 0;
    private long cookies = 0L, income = 0L, clickPower = 1L;

    public CookieClickerScene(CookieClickerApplication app, AnchorPane root) {
        super(app, root);

        // init layout
        initPanesAndLayout();
        initEventHandlersAndTimers();

        root.getChildren().addAll(iviewCookie, paneText, textLeft, textRight, textFlowStats);

        // sounds
        mplayerCookie = new MediaPlayer(Main.res.getMedia("cookieClickerChew"));
        mplayerButton = new MediaPlayer(Main.res.getMedia("button"));

        mplayerCookie.setVolume(mplayerCookie.getVolume());
        mplayerButton.setVolume(0.2d);
    }



    private void initPanesAndLayout() {
        // background image
        Image bgImage = Main.res.getImage("cookieClickerBackground");
        ToriaFX.setResizableBackgroundImage(root, bgImage);
        root.setMinSize(bgImage.getWidth(), bgImage.getHeight());

        // cookie
        iviewCookie = new ImageView(Main.res.getImage("cookieClickerCookie"));
        iviewCookie.setFitWidth(250);
        iviewCookie.setPreserveRatio(true);
        final double iviewAnchLeft = 130d, iviewAnchBottom = 130d, iviewGrow = 50d;
        AnchorPane.setLeftAnchor(iviewCookie, iviewAnchLeft);
        AnchorPane.setBottomAnchor(iviewCookie, iviewAnchBottom);
        iviewCookie.setOnMousePressed(event -> {
            if(event.getButton() != MouseButton.PRIMARY) return;
            iviewCookie.setFitWidth(iviewCookie.getFitWidth() + iviewGrow);
            AnchorPane.setLeftAnchor(iviewCookie, iviewAnchLeft - iviewGrow / 2);
            AnchorPane.setBottomAnchor(iviewCookie, iviewAnchBottom - iviewGrow / 2);
            cookies += clickPower;
            mplayerCookie.seek(Duration.ZERO);
            mplayerCookie.play();
            resetStatTexts();
        });
        iviewCookie.setOnZoom(event -> {});
        iviewCookie.setOnMouseReleased(event -> {
            if(event.getButton() != MouseButton.PRIMARY) return;
            iviewCookie.setFitWidth(iviewCookie.getFitWidth() - iviewGrow);
            AnchorPane.setLeftAnchor(iviewCookie, iviewAnchLeft);
            AnchorPane.setBottomAnchor(iviewCookie, iviewAnchBottom);
            updateTexts();
        });

        // textfields
        textCookies = new Text("Cookies: " + cookies);
        textClick = new Text("Click: " + clickPower);
        textIncome = new Text("Income: " + income);
        paneText = new VBox(textCookies, textClick, textIncome);
        paneText.setSpacing(5);
        Text[] texts = new Text[]{ textClick, textCookies, textIncome };
        for(Text t : texts){
            t.setFont(Font.font("arial", 35d));
            t.setFill(Color.WHITE);
            VBox.setVgrow(t, Priority.ALWAYS);
        }
        AnchorPane.setTopAnchor(paneText, 50d);
        AnchorPane.setLeftAnchor(paneText, 125d);

        // texts
        initTextsAndTextArrays();
        textLeft = new Text("<"); textRight = new Text(">");
        textRight.setOnMouseClicked(event -> {
            if(currentPage == 2) return;
            currentPage += 1;
            updatePage();
            mplayerButton.seek(Duration.ZERO);
            mplayerButton.play();
        });
        textLeft.setOnMouseClicked(event -> {
            if(currentPage == 0) return;
            currentPage -= 1;
            updatePage();
            mplayerButton.seek(Duration.ZERO);
            mplayerButton.play();
        });
        updatePage();
        for(Text t : new Text[]{textLeft, textRight}){
            t.setFont(Font.font("arial", 40d));
            t.setFill(Color.WHITE);
            t.setOnMouseEntered(event -> {t.setFill(Color.YELLOW); t.setEffect(new Bloom());});
            t.setOnMouseExited(event -> {t.setFill(Color.WHITE); t.setEffect(null);});
            AnchorPane.setTopAnchor(t, 80d);
        }
        AnchorPane.setRightAnchor(textRight, 130d);
        AnchorPane.setRightAnchor(textLeft, 230d);

    }

    private void initEventHandlersAndTimers(){
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {@Override public void run() {
            cookies += income;
            updateTexts();
        }}, 200, 1000);
    }


    private void initTextsAndTextArrays() {
        textCookieStand = new Text("Cookie Stand"); textCookiePistol = new Text("Cookie Pistol");
        textCookieSlave = new Text("Cookie Slave"); textCookieBakery = new Text("Cookie Bakery");
        textCookieGun = new Text("Cookie Gun"); textCookieTree = new Text("Cookie Tree");
        textCookieFarm = new Text("Cookie Farm"); textCookieThief = new Text("Cookie Thief");
        textCookieBank = new Text("Cookie Bank"); textCookieChef = new Text("Cookie Chef");
        textCookieCEO = new Text("Cookie CEO"); textCookieFactory = new Text("Cookie Factory");
        textNatosCookieStash = new Text("Nato's Cookie Stash"); textGodsCookieStash = new Text("God's Cookie Stash");
        textGrandmasStash = new Text("Grandma's Stash");

        textsFirst = new Text[]{textCookieStand, textCookiePistol, textCookieSlave, textCookieBakery, textCookieGun};
        textsSecond = new Text[]{textCookieTree, textCookieFarm, textCookieThief, textCookieBank, textCookieChef};
        textsThird = new Text[]{textCookieCEO, textCookieFactory, textNatosCookieStash, textGodsCookieStash, textGrandmasStash};

        textStatName = new Text(""); textStatCost = new Text(""); textStatClick = new Text(""); textStatIncome = new Text("");
        textFlowStats = new TextFlow(textStatName, textStatCost, textStatClick, textStatIncome);
        textFlowStats.getChildren().forEach( node -> {
            Text t = (Text) node;
            t.setFont(Font.font("arial", 30d));
            t.setFill(Color.WHITE);
        });
        AnchorPane.setRightAnchor(textFlowStats, 120d);
        AnchorPane.setTopAnchor(textFlowStats, 150d+50*4+100);

        Text[][] textArrays = new Text[][]{ textsFirst, textsSecond, textsThird };
        int i = 0;
        for(Text[] arr : textArrays){
            for (Text t : arr){
                int nth = i++ % 5;
                t.setFont(Font.font("arial", 30d));
                t.setFill(Color.WHITE);
                t.setUserData(1d);
                t.setOnMouseClicked(event -> {
                    Buyable buyable = Buyable.getBuyable(t, currentPage, nth);
                    if(cookies >= buyable.cost){
                        cookies -= buyable.cost;
                        clickPower += buyable.clickPower;
                        income += buyable.income;
                        t.setUserData( ((double) t.getUserData()) * 1.6d );
                        mplayerButton.seek(Duration.ZERO);
                        mplayerButton.play();
                        updateTexts();
                    }
                });
                t.setOnMouseEntered(event -> {
                    if(currentPage == 0) t.setFill(Color.YELLOW);
                    if(currentPage == 1) t.setFill(Color.LIME);
                    if(currentPage == 2) t.setFill(Color.TURQUOISE);
                    t.setEffect(new Bloom());
                    updateStatTexts(t, currentPage, nth);
                });
                t.setOnMouseExited(event -> {
                    t.setFill(Color.WHITE);
                    t.setEffect(null);
                });
                AnchorPane.setRightAnchor(t, 120d);
                if(nth == 0) AnchorPane.setTopAnchor(t, 150d);
                if(nth == 1) AnchorPane.setTopAnchor(t, 150d+50);
                if(nth == 2) AnchorPane.setTopAnchor(t, 150d+50*2);
                if(nth == 3) AnchorPane.setTopAnchor(t, 150d+50*3);
                if(nth == 4) AnchorPane.setTopAnchor(t, 150d+50*4);
            }
        }

    }


    /*  UPDATING METHODS  */

    private void updateTexts(){
        textCookies.setText("Cookies: " + cookies);
        textClick.setText("Click: " + clickPower);
        textIncome.setText("Income: " + income);
    }

    private void updateStatTexts(Text text, int currentPage, int nth) {
        Buyable buyable = Buyable.getBuyable(text, currentPage, nth);
        textStatName.setText("Name: " + text.getText() + "\n");
        textStatCost.setText("Cost: " + buyable.cost + "\n");
        textStatClick.setText("Click: " + buyable.clickPower + "\n");
        textStatIncome.setText("Income: " + buyable.income + "\n");
    }

    private void resetStatTexts() {
        textFlowStats.getChildren().forEach( node -> { ((Text) node).setText(""); } );
    }

    private void updatePage() {
        if(currentPage == 0){
            root.getChildren().addAll(textsFirst);
            root.getChildren().removeAll(textsSecond);
            root.getChildren().removeAll(textsThird);
        }
        else if(currentPage == 1){
            root.getChildren().removeAll(textsFirst);
            root.getChildren().addAll(textsSecond);
            root.getChildren().removeAll(textsThird);
        }
        else if(currentPage == 2){
            root.getChildren().removeAll(textsFirst);
            root.getChildren().removeAll(textsSecond);
            root.getChildren().addAll(textsThird);
        }
    }



}
