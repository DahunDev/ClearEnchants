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
      if ((cmd.getName().equalsIgnoreCase("disenchant") ||  (cmd.getName().equalsIgnoreCase("��þƮ�ʱ�ȭ"))) && (sender.hasPermission("disenchant.use")))
      {
		ItemStack item = ((Player)sender).getItemInHand();

        if (item.getEnchantments().size() < 1)
        {
          sender.sendMessage("��b[ ��fServer ��b] " + ChatColor.RED + "����� ��� �ִ� �������� �ο��� ���/���� ȿ���� �����ϴ�! The item you are holding has no Enchantments!");
          return true;
        }
        for(Enchantment enchant : Enchantment.values()) {
        	item.removeEnchantment(enchant);
        }

        sender.sendMessage("��b[ ��fServer ��b] " + ChatColor.GREEN + "��þƮ �ʱ�ȭ�� �Ϸ�Ǿ����ϴ�. Your enchantments have been removed. :O");
      }

    }
    else
    {
      sender.sendMessage("��b[ ��fServer ��b] " + ChatColor.RED + "���� �÷��̾ ����� ������ ��ɾ� �Դϴ�. Only in-game players can use this command.");
    }

    return false;
  }
}