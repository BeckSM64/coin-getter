package com.becksm64.coingetter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Random;

public class PauseMenu {

    private Stage stage;
    private Label pauseLabel;
    private BitmapFont font;
    private Random rng;

    public PauseMenu(SpriteBatch batch) {

        rng = new Random();

        //Generate font
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/cour.TTF"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = (int) (50 * Gdx.graphics.getDensity());
        font = generator.generateFont(parameter);
        generator.dispose();

        Viewport viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        stage = new Stage(viewport, batch);
        Table table = new Table();
        table.setFillParent(true);

        Skin skin = new Skin(Gdx.files.internal("skins/uiskin.json"));

        pauseLabel = new Label("[PAUSE]", skin);
        pauseLabel.setStyle(new Label.LabelStyle(font, Color.WHITE));

        table.add(pauseLabel);
        stage.addActor(table);
    }

    private void changePauseColor() {
        pauseLabel.setStyle(new Label.LabelStyle(font, new Color(rng.nextFloat(), rng.nextFloat(), rng.nextFloat(), 1)));
    }

    public Stage getStage() {
        changePauseColor();
        return this.stage;
    }

    public void dispose() {
        stage.dispose();
    }
}