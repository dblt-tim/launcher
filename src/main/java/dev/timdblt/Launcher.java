package dev.timdblt;

import dev.timdblt.ui.PanelManager;
import dev.timdblt.utils.Helpers;
import fr.flowarg.flowlogger.ILogger;
import fr.flowarg.flowlogger.Logger;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;

public class Launcher extends Application {

    private PanelManager panelManager;
    private static Launcher instance;
    private final ILogger logger;
    private File launcherDir = Helpers.generateGamePath("FuFX");

    public static Launcher getInstance() {
        return instance;
    }

    public ILogger getLogger() {
        return logger;
    }

    public Launcher() {
        instance = this;
        this.logger = new Logger("[FuFX]", new File(this.launcherDir, "launcher.log").toPath());
        this.launcherDir.mkdirs();
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.logger.info("Starting launcher...");
        this.panelManager = new PanelManager(this, stage);
        this.panelManager.init();
    }
}
