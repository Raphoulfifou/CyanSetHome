package fr.raphoulfifou.sethome;

import fr.raphoulfifou.sethome.commands.SetCommands;
import fr.raphoulfifou.sethome.commands.SetHomeCommand;
import fr.raphoulfifou.sethome.commands.TeleportationCommands;
import fr.raphoulfifou.sethome.util.SetHomeJSONConfig;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @since 0.0.1
 * @see HomeClientCore
 * @author Raphoulfifou
 */
@Environment(EnvType.SERVER)
public class HomeServerCore implements DedicatedServerModInitializer {
    public static final String MODID = "sh";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static final String MODNAME = "[SetHome]";
    public static SetHomeJSONConfig config = new SetHomeJSONConfig();

    @Override
    // Initialize the differents instances (here commands) when lauched on server
    public void onInitializeServer() {
        // Loads the homes
        config.load();

        // Register all the commands
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            TeleportationCommands.register(dispatcher);
            SetHomeCommand.register(dispatcher);
            SetCommands.register(dispatcher);
        });
        HomeServerCore.LOGGER.info("{} Successfully initialized commands", MODNAME);
        HomeServerCore.LOGGER.info("{} Successfully completed initialization", MODNAME);
    }
}