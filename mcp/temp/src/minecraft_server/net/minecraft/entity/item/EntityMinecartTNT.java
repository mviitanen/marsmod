package net.minecraft.entity.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRailBase;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class EntityMinecartTNT extends EntityMinecart {

   private int field_94106_a = -1;
   private static final String __OBFID = "CL_00001680";


   public EntityMinecartTNT(World p_i1727_1_) {
      super(p_i1727_1_);
   }

   public EntityMinecartTNT(World p_i1728_1_, double p_i1728_2_, double p_i1728_4_, double p_i1728_6_) {
      super(p_i1728_1_, p_i1728_2_, p_i1728_4_, p_i1728_6_);
   }

   public int func_94087_l() {
      return 3;
   }

   public Block func_145817_o() {
      return Blocks.field_150335_W;
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      if(this.field_94106_a > 0) {
         --this.field_94106_a;
         this.field_70170_p.func_72869_a("smoke", this.field_70165_t, this.field_70163_u + 0.5D, this.field_70161_v, 0.0D, 0.0D, 0.0D);
      } else if(this.field_94106_a == 0) {
         this.func_94103_c(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
      }

      if(this.field_70123_F) {
         double var1 = this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y;
         if(var1 >= 0.009999999776482582D) {
            this.func_94103_c(var1);
         }
      }

   }

   public void func_94095_a(DamageSource p_94095_1_) {
      super.func_94095_a(p_94095_1_);
      double var2 = this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y;
      if(!p_94095_1_.func_94541_c()) {
         this.func_70099_a(new ItemStack(Blocks.field_150335_W, 1), 0.0F);
      }

      if(p_94095_1_.func_76347_k() || p_94095_1_.func_94541_c() || var2 >= 0.009999999776482582D) {
         this.func_94103_c(var2);
      }

   }

   protected void func_94103_c(double p_94103_1_) {
      if(!this.field_70170_p.field_72995_K) {
         double var3 = Math.sqrt(p_94103_1_);
         if(var3 > 5.0D) {
            var3 = 5.0D;
         }

         this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, (float)(4.0D + this.field_70146_Z.nextDouble() * 1.5D * var3), true);
         this.func_70106_y();
      }

   }

   protected void func_70069_a(float p_70069_1_) {
      if(p_70069_1_ >= 3.0F) {
         float var2 = p_70069_1_ / 10.0F;
         this.func_94103_c((double)(var2 * var2));
      }

      super.func_70069_a(p_70069_1_);
   }

   public void func_96095_a(int p_96095_1_, int p_96095_2_, int p_96095_3_, boolean p_96095_4_) {
      if(p_96095_4_ && this.field_94106_a < 0) {
         this.func_94105_c();
      }

   }

   public void func_94105_c() {
      this.field_94106_a = 80;
      if(!this.field_70170_p.field_72995_K) {
         this.field_70170_p.func_72960_a(this, (byte)10);
         this.field_70170_p.func_72956_a(this, "game.tnt.primed", 1.0F, 1.0F);
      }

   }

   public boolean func_96096_ay() {
      return this.field_94106_a > -1;
   }

   public float func_145772_a(Explosion p_145772_1_, World p_145772_2_, int p_145772_3_, int p_145772_4_, int p_145772_5_, Block p_145772_6_) {
      return this.func_96096_ay() && (BlockRailBase.func_150051_a(p_145772_6_) || BlockRailBase.func_150049_b_(p_145772_2_, p_145772_3_, p_145772_4_ + 1, p_145772_5_))?0.0F:super.func_145772_a(p_145772_1_, p_145772_2_, p_145772_3_, p_145772_4_, p_145772_5_, p_145772_6_);
   }

   public boolean func_145774_a(Explosion p_145774_1_, World p_145774_2_, int p_145774_3_, int p_145774_4_, int p_145774_5_, Block p_145774_6_, float p_145774_7_) {
      return this.func_96096_ay() && (BlockRailBase.func_150051_a(p_145774_6_) || BlockRailBase.func_150049_b_(p_145774_2_, p_145774_3_, p_145774_4_ + 1, p_145774_5_))?false:super.func_145774_a(p_145774_1_, p_145774_2_, p_145774_3_, p_145774_4_, p_145774_5_, p_145774_6_, p_145774_7_);
   }

   protected void func_70037_a(NBTTagCompound p_70037_1_) {
      super.func_70037_a(p_70037_1_);
      if(p_70037_1_.func_150297_b("TNTFuse", 99)) {
         this.field_94106_a = p_70037_1_.func_74762_e("TNTFuse");
      }

   }

   protected void func_70014_b(NBTTagCompound p_70014_1_) {
      super.func_70014_b(p_70014_1_);
      p_70014_1_.func_74768_a("TNTFuse", this.field_94106_a);
   }
}
