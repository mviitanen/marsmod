package net.minecraft.network.play.server;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.MathHelper;

public class S0CPacketSpawnPlayer extends Packet {

   private int field_148957_a;
   private GameProfile field_148955_b;
   private int field_148956_c;
   private int field_148953_d;
   private int field_148954_e;
   private byte field_148951_f;
   private byte field_148952_g;
   private int field_148959_h;
   private DataWatcher field_148960_i;
   private List field_148958_j;
   private static final String __OBFID = "CL_00001281";


   public S0CPacketSpawnPlayer() {}

   public S0CPacketSpawnPlayer(EntityPlayer p_i45171_1_) {
      this.field_148957_a = p_i45171_1_.func_145782_y();
      this.field_148955_b = p_i45171_1_.func_146103_bH();
      this.field_148956_c = MathHelper.func_76128_c(p_i45171_1_.field_70165_t * 32.0D);
      this.field_148953_d = MathHelper.func_76128_c(p_i45171_1_.field_70163_u * 32.0D);
      this.field_148954_e = MathHelper.func_76128_c(p_i45171_1_.field_70161_v * 32.0D);
      this.field_148951_f = (byte)((int)(p_i45171_1_.field_70177_z * 256.0F / 360.0F));
      this.field_148952_g = (byte)((int)(p_i45171_1_.field_70125_A * 256.0F / 360.0F));
      ItemStack var2 = p_i45171_1_.field_71071_by.func_70448_g();
      this.field_148959_h = var2 == null?0:Item.func_150891_b(var2.func_77973_b());
      this.field_148960_i = p_i45171_1_.func_70096_w();
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_148957_a = p_148837_1_.func_150792_a();
      UUID var2 = UUID.fromString(p_148837_1_.func_150789_c(36));
      this.field_148955_b = new GameProfile(var2, p_148837_1_.func_150789_c(16));
      int var3 = p_148837_1_.func_150792_a();

      for(int var4 = 0; var4 < var3; ++var4) {
         String var5 = p_148837_1_.func_150789_c(32767);
         String var6 = p_148837_1_.func_150789_c(32767);
         String var7 = p_148837_1_.func_150789_c(32767);
         this.field_148955_b.getProperties().put(var5, new Property(var5, var6, var7));
      }

      this.field_148956_c = p_148837_1_.readInt();
      this.field_148953_d = p_148837_1_.readInt();
      this.field_148954_e = p_148837_1_.readInt();
      this.field_148951_f = p_148837_1_.readByte();
      this.field_148952_g = p_148837_1_.readByte();
      this.field_148959_h = p_148837_1_.readShort();
      this.field_148958_j = DataWatcher.func_151508_b(p_148837_1_);
   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.func_150787_b(this.field_148957_a);
      UUID var2 = this.field_148955_b.getId();
      p_148840_1_.func_150785_a(var2 == null?"":var2.toString());
      p_148840_1_.func_150785_a(this.field_148955_b.getName());
      p_148840_1_.func_150787_b(this.field_148955_b.getProperties().size());
      Iterator var3 = this.field_148955_b.getProperties().values().iterator();

      while(var3.hasNext()) {
         Property var4 = (Property)var3.next();
         p_148840_1_.func_150785_a(var4.getName());
         p_148840_1_.func_150785_a(var4.getValue());
         p_148840_1_.func_150785_a(var4.getSignature());
      }

      p_148840_1_.writeInt(this.field_148956_c);
      p_148840_1_.writeInt(this.field_148953_d);
      p_148840_1_.writeInt(this.field_148954_e);
      p_148840_1_.writeByte(this.field_148951_f);
      p_148840_1_.writeByte(this.field_148952_g);
      p_148840_1_.writeShort(this.field_148959_h);
      this.field_148960_i.func_151509_a(p_148840_1_);
   }

   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
      p_148833_1_.func_147237_a(this);
   }

   public String func_148835_b() {
      return String.format("id=%d, gameProfile=\'%s\', x=%.2f, y=%.2f, z=%.2f, carried=%d", new Object[]{Integer.valueOf(this.field_148957_a), this.field_148955_b, Float.valueOf((float)this.field_148956_c / 32.0F), Float.valueOf((float)this.field_148953_d / 32.0F), Float.valueOf((float)this.field_148954_e / 32.0F), Integer.valueOf(this.field_148959_h)});
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_148833_a((INetHandlerPlayClient)p_148833_1_);
   }
}
