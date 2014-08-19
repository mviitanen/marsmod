package net.minecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityBeacon;

public class ContainerBeacon extends Container {

   private TileEntityBeacon field_82866_e;
   private final ContainerBeacon.BeaconSlot field_82864_f;
   private int field_82865_g;
   private int field_82867_h;
   private int field_82868_i;
   private static final String __OBFID = "CL_00001735";


   public ContainerBeacon(InventoryPlayer p_i1802_1_, TileEntityBeacon p_i1802_2_) {
      this.field_82866_e = p_i1802_2_;
      this.func_75146_a(this.field_82864_f = new ContainerBeacon.BeaconSlot(p_i1802_2_, 0, 136, 110));
      byte var3 = 36;
      short var4 = 137;

      int var5;
      for(var5 = 0; var5 < 3; ++var5) {
         for(int var6 = 0; var6 < 9; ++var6) {
            this.func_75146_a(new Slot(p_i1802_1_, var6 + var5 * 9 + 9, var3 + var6 * 18, var4 + var5 * 18));
         }
      }

      for(var5 = 0; var5 < 9; ++var5) {
         this.func_75146_a(new Slot(p_i1802_1_, var5, var3 + var5 * 18, 58 + var4));
      }

      this.field_82865_g = p_i1802_2_.func_145998_l();
      this.field_82867_h = p_i1802_2_.func_146007_j();
      this.field_82868_i = p_i1802_2_.func_146006_k();
   }

   public void func_75132_a(ICrafting p_75132_1_) {
      super.func_75132_a(p_75132_1_);
      p_75132_1_.func_71112_a(this, 0, this.field_82865_g);
      p_75132_1_.func_71112_a(this, 1, this.field_82867_h);
      p_75132_1_.func_71112_a(this, 2, this.field_82868_i);
   }

   public void func_75137_b(int p_75137_1_, int p_75137_2_) {
      if(p_75137_1_ == 0) {
         this.field_82866_e.func_146005_c(p_75137_2_);
      }

      if(p_75137_1_ == 1) {
         this.field_82866_e.func_146001_d(p_75137_2_);
      }

      if(p_75137_1_ == 2) {
         this.field_82866_e.func_146004_e(p_75137_2_);
      }

   }

   public TileEntityBeacon func_148327_e() {
      return this.field_82866_e;
   }

   public boolean func_75145_c(EntityPlayer p_75145_1_) {
      return this.field_82866_e.func_70300_a(p_75145_1_);
   }

   public ItemStack func_82846_b(EntityPlayer p_82846_1_, int p_82846_2_) {
      ItemStack var3 = null;
      Slot var4 = (Slot)this.field_75151_b.get(p_82846_2_);
      if(var4 != null && var4.func_75216_d()) {
         ItemStack var5 = var4.func_75211_c();
         var3 = var5.func_77946_l();
         if(p_82846_2_ == 0) {
            if(!this.func_75135_a(var5, 1, 37, true)) {
               return null;
            }

            var4.func_75220_a(var5, var3);
         } else if(!this.field_82864_f.func_75216_d() && this.field_82864_f.func_75214_a(var5) && var5.field_77994_a == 1) {
            if(!this.func_75135_a(var5, 0, 1, false)) {
               return null;
            }
         } else if(p_82846_2_ >= 1 && p_82846_2_ < 28) {
            if(!this.func_75135_a(var5, 28, 37, false)) {
               return null;
            }
         } else if(p_82846_2_ >= 28 && p_82846_2_ < 37) {
            if(!this.func_75135_a(var5, 1, 28, false)) {
               return null;
            }
         } else if(!this.func_75135_a(var5, 1, 37, false)) {
            return null;
         }

         if(var5.field_77994_a == 0) {
            var4.func_75215_d((ItemStack)null);
         } else {
            var4.func_75218_e();
         }

         if(var5.field_77994_a == var3.field_77994_a) {
            return null;
         }

         var4.func_82870_a(p_82846_1_, var5);
      }

      return var3;
   }

   class BeaconSlot extends Slot {

      private static final String __OBFID = "CL_00001736";


      public BeaconSlot(IInventory p_i1801_2_, int p_i1801_3_, int p_i1801_4_, int p_i1801_5_) {
         super(p_i1801_2_, p_i1801_3_, p_i1801_4_, p_i1801_5_);
      }

      public boolean func_75214_a(ItemStack p_75214_1_) {
         return p_75214_1_ == null?false:p_75214_1_.func_77973_b() == Items.field_151166_bC || p_75214_1_.func_77973_b() == Items.field_151045_i || p_75214_1_.func_77973_b() == Items.field_151043_k || p_75214_1_.func_77973_b() == Items.field_151042_j;
      }

      public int func_75219_a() {
         return 1;
      }
   }
}
