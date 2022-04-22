package eu.tetemh.fkplugin;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Runnable {
    public static void startDay (int timeDay, Player player){

        new BukkitRunnable() {
            public void run() {
                Runnable.sendTitle(player, "Coucou", "", 60);
                if(Main.getInstance().day >= Main.getInstance().getConfig().getInt("Rules.NetherDay")){
                    Main.getInstance().getServer().getAllowNether();
                }
                switch (Main.getInstance().day) {
                    case 1 :
                        break;
                    case 2 :
                        break;
                    case 3 :
                        break;
                }
            }
        }.runTaskTimer(Main.getInstance(), 0, (20 * 60 * timeDay));
    }



    public static void sendTitle(Player player, String msgTitle, String msgSubTitle, int ticks) {
        IChatBaseComponent chatTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + msgTitle + "\"}");
        IChatBaseComponent chatSubTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + msgSubTitle + "\"}");
        PacketPlayOutTitle p = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, chatTitle);
        PacketPlayOutTitle p2 = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, chatSubTitle);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(p);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(p2);
        sendTime(player, ticks);
    }

    private static void sendTime(Player player, int ticks) {
        PacketPlayOutTitle p = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, null, 40, ticks, 40);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(p);
    }

    public static void sendActionBar(Player player, String message) {
        IChatBaseComponent cbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + message + "\"}");
        PacketPlayOutChat ppoc = new PacketPlayOutChat(cbc, (byte) 2);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(ppoc);
    }
}
