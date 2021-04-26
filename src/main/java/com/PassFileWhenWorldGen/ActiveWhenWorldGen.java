package com.PassFileWhenWorldGen;

import com.mojang.realmsclient.util.RealmsTasks;
import net.minecraft.realms.RealmsScreen;

public class ActiveWhenWorldGen  extends RealmsTasks.WorldCreationTask{
    public ActiveWhenWorldGen(long worldId, String name, String motd, RealmsScreen lastScreen) {
        super(worldId, name, motd, lastScreen);
    }

    @Override
    public void run() {
        RunnableUpdate.MyRun();
    }
}
