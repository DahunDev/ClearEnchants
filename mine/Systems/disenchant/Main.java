package mine.Systems.disenchant;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
	@Override
  public void onEnable()
  {
  }


	@Override
  public void onDisable()
  
  {
  }

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if ((sender instanceof Player))
    {
      if ((cmd.getName().equalsIgnoreCase("disenchant") ||  (cmd.getName().equalsIgnoreCase("인첸트초기화"))) && (sender.hasPermission("disenchant.use")))
      {
		ItemStack item = ((Player)sender).getItemInHand();

        if (item.getEnchantments().size() < 1)
        {
          sender.sendMessage("§b[ §fServer §b] " + ChatColor.RED + "당신이 들고 있는 아이템은 부여된 요술/마법 효과가 없습니다! The item you are holding has no Enchantments!");
          return true;
        }
        for(Enchantment enchant : Enchantment.values()) {
        	item.removeEnchantment(enchant);
        }

        sender.sendMessage("§b[ §fServer §b] " + ChatColor.GREEN + "인첸트 초기화가 완료되었습니다. Your enchantments have been removed. :O");
      }

    }
    else
    {
      sender.sendMessage("§b[ §fServer §b] " + ChatColor.RED + "오직 플레이어만 사용이 가능한 명령어 입니다. Only in-game players can use this command.");
    }

    return false;
  }
}