package net.minecraft.entity;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ReportedException;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public abstract class Entity {

   private static int field_70152_a;
   private int field_145783_c;
   public double field_70155_l;
   public boolean field_70156_m;
   public Entity field_70153_n;
   public Entity field_70154_o;
   public boolean field_98038_p;
   public World field_70170_p;
   public double field_70169_q;
   public double field_70167_r;
   public double field_70166_s;
   public double field_70165_t;
   public double field_70163_u;
   public double field_70161_v;
   public double field_70159_w;
   public double field_70181_x;
   public double field_70179_y;
   public float field_70177_z;
   public float field_70125_A;
   public float field_70126_B;
   public float field_70127_C;
   public final AxisAlignedBB field_70121_D;
   public boolean field_70122_E;
   public boolean field_70123_F;
   public boolean field_70124_G;
   public boolean field_70132_H;
   public boolean field_70133_I;
   protected boolean field_70134_J;
   public boolean field_70135_K;
   public boolean field_70128_L;
   public float field_70129_M;
   public float field_70130_N;
   public float field_70131_O;
   public float field_70141_P;
   public float field_70140_Q;
   public float field_82151_R;
   public float field_70143_R;
   private int field_70150_b;
   public double field_70142_S;
   public double field_70137_T;
   public double field_70136_U;
   public float field_70139_V;
   public float field_70138_W;
   public boolean field_70145_X;
   public float field_70144_Y;
   protected Random field_70146_Z;
   public int field_70173_aa;
   public int field_70174_ab;
   private int field_70151_c;
   protected boolean field_70171_ac;
   public int field_70172_ad;
   private boolean field_70148_d;
   protected boolean field_70178_ae;
   protected DataWatcher field_70180_af;
   private double field_70149_e;
   private double field_70147_f;
   public boolean field_70175_ag;
   public int field_70176_ah;
   public int field_70162_ai;
   public int field_70164_aj;
   public boolean field_70158_ak;
   public boolean field_70160_al;
   public int field_71088_bW;
   protected boolean field_71087_bX;
   protected int field_82153_h;
   public int field_71093_bK;
   protected int field_82152_aq;
   private boolean field_83001_bt;
   protected UUID field_96093_i;
   public Entity.EnumEntitySize field_70168_am;
   private static final String __OBFID = "CL_00001533";


   public int func_145782_y() {
      return this.field_145783_c;
   }

   public void func_145769_d(int p_145769_1_) {
      this.field_145783_c = p_145769_1_;
   }

   public Entity(World p_i1582_1_) {
      this.field_145783_c = field_70152_a++;
      this.field_70155_l = 1.0D;
      this.field_70121_D = AxisAlignedBB.func_72330_a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
      this.field_70135_K = true;
      this.field_70130_N = 0.6F;
      this.field_70131_O = 1.8F;
      this.field_70150_b = 1;
      this.field_70146_Z = new Random();
      this.field_70174_ab = 1;
      this.field_70148_d = true;
      this.field_96093_i = UUID.randomUUID();
      this.field_70168_am = Entity.EnumEntitySize.SIZE_2;
      this.field_70170_p = p_i1582_1_;
      this.func_70107_b(0.0D, 0.0D, 0.0D);
      if(p_i1582_1_ != null) {
         this.field_71093_bK = p_i1582_1_.field_73011_w.field_76574_g;
      }

      this.field_70180_af = new DataWatcher(this);
      this.field_70180_af.func_75682_a(0, Byte.valueOf((byte)0));
      this.field_70180_af.func_75682_a(1, Short.valueOf((short)300));
      this.func_70088_a();
   }

   protected abstract void func_70088_a();

   public DataWatcher func_70096_w() {
      return this.field_70180_af;
   }

   public boolean equals(Object p_equals_1_) {
      return p_equals_1_ instanceof Entity?((Entity)p_equals_1_).field_145783_c == this.field_145783_c:false;
   }

   public int hashCode() {
      return this.field_145783_c;
   }

   public void func_70106_y() {
      this.field_70128_L = true;
   }

   protected void func_70105_a(float p_70105_1_, float p_70105_2_) {
      float var3;
      if(p_70105_1_ != this.field_70130_N || p_70105_2_ != this.field_70131_O) {
         var3 = this.field_70130_N;
         this.field_70130_N = p_70105_1_;
         this.field_70131_O = p_70105_2_;
         this.field_70121_D.field_72336_d = this.field_70121_D.field_72340_a + (double)this.field_70130_N;
         this.field_70121_D.field_72334_f = this.field_70121_D.field_72339_c + (double)this.field_70130_N;
         this.field_70121_D.field_72337_e = this.field_70121_D.field_72338_b + (double)this.field_70131_O;
         if(this.field_70130_N > var3 && !this.field_70148_d && !this.field_70170_p.field_72995_K) {
            this.func_70091_d((double)(var3 - this.field_70130_N), 0.0D, (double)(var3 - this.field_70130_N));
         }
      }

      var3 = p_70105_1_ % 2.0F;
      if((double)var3 < 0.375D) {
         this.field_70168_am = Entity.EnumEntitySize.SIZE_1;
      } else if((double)var3 < 0.75D) {
         this.field_70168_am = Entity.EnumEntitySize.SIZE_2;
      } else if((double)var3 < 1.0D) {
         this.field_70168_am = Entity.EnumEntitySize.SIZE_3;
      } else if((double)var3 < 1.375D) {
         this.field_70168_am = Entity.EnumEntitySize.SIZE_4;
      } else if((double)var3 < 1.75D) {
         this.field_70168_am = Entity.EnumEntitySize.SIZE_5;
      } else {
         this.field_70168_am = Entity.EnumEntitySize.SIZE_6;
      }

   }

   protected void func_70101_b(float p_70101_1_, float p_70101_2_) {
      this.field_70177_z = p_70101_1_ % 360.0F;
      this.field_70125_A = p_70101_2_ % 360.0F;
   }

   public void func_70107_b(double p_70107_1_, double p_70107_3_, double p_70107_5_) {
      this.field_70165_t = p_70107_1_;
      this.field_70163_u = p_70107_3_;
      this.field_70161_v = p_70107_5_;
      float var7 = this.field_70130_N / 2.0F;
      float var8 = this.field_70131_O;
      this.field_70121_D.func_72324_b(p_70107_1_ - (double)var7, p_70107_3_ - (double)this.field_70129_M + (double)this.field_70139_V, p_70107_5_ - (double)var7, p_70107_1_ + (double)var7, p_70107_3_ - (double)this.field_70129_M + (double)this.field_70139_V + (double)var8, p_70107_5_ + (double)var7);
   }

   public void func_70071_h_() {
      this.func_70030_z();
   }

   public void func_70030_z() {
      this.field_70170_p.field_72984_F.func_76320_a("entityBaseTick");
      if(this.field_70154_o != null && this.field_70154_o.field_70128_L) {
         this.field_70154_o = null;
      }

      this.field_70141_P = this.field_70140_Q;
      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      this.field_70127_C = this.field_70125_A;
      this.field_70126_B = this.field_70177_z;
      int var2;
      if(!this.field_70170_p.field_72995_K && this.field_70170_p instanceof WorldServer) {
         this.field_70170_p.field_72984_F.func_76320_a("portal");
         MinecraftServer var1 = ((WorldServer)this.field_70170_p).func_73046_m();
         var2 = this.func_82145_z();
         if(this.field_71087_bX) {
            if(var1.func_71255_r()) {
               if(this.field_70154_o == null && this.field_82153_h++ >= var2) {
                  this.field_82153_h = var2;
                  this.field_71088_bW = this.func_82147_ab();
                  byte var3;
                  if(this.field_70170_p.field_73011_w.field_76574_g == -1) {
                     var3 = 0;
                  } else {
                     var3 = -1;
                  }

                  this.func_71027_c(var3);
               }

               this.field_71087_bX = false;
            }
         } else {
            if(this.field_82153_h > 0) {
               this.field_82153_h -= 4;
            }

            if(this.field_82153_h < 0) {
               this.field_82153_h = 0;
            }
         }

         if(this.field_71088_bW > 0) {
            --this.field_71088_bW;
         }

         this.field_70170_p.field_72984_F.func_76319_b();
      }

      if(this.func_70051_ag() && !this.func_70090_H()) {
         int var5 = MathHelper.func_76128_c(this.field_70165_t);
         var2 = MathHelper.func_76128_c(this.field_70163_u - 0.20000000298023224D - (double)this.field_70129_M);
         int var6 = MathHelper.func_76128_c(this.field_70161_v);
         Block var4 = this.field_70170_p.func_147439_a(var5, var2, var6);
         if(var4.func_149688_o() != Material.field_151579_a) {
            this.field_70170_p.func_72869_a("blockcrack_" + Block.func_149682_b(var4) + "_" + this.field_70170_p.func_72805_g(var5, var2, var6), this.field_70165_t + ((double)this.field_70146_Z.nextFloat() - 0.5D) * (double)this.field_70130_N, this.field_70121_D.field_72338_b + 0.1D, this.field_70161_v + ((double)this.field_70146_Z.nextFloat() - 0.5D) * (double)this.field_70130_N, -this.field_70159_w * 4.0D, 1.5D, -this.field_70179_y * 4.0D);
         }
      }

      this.func_70072_I();
      if(this.field_70170_p.field_72995_K) {
         this.field_70151_c = 0;
      } else if(this.field_70151_c > 0) {
         if(this.field_70178_ae) {
            this.field_70151_c -= 4;
            if(this.field_70151_c < 0) {
               this.field_70151_c = 0;
            }
         } else {
            if(this.field_70151_c % 20 == 0) {
               this.func_70097_a(DamageSource.field_76370_b, 1.0F);
            }

            --this.field_70151_c;
         }
      }

      if(this.func_70058_J()) {
         this.func_70044_A();
         this.field_70143_R *= 0.5F;
      }

      if(this.field_70163_u < -64.0D) {
         this.func_70076_C();
      }

      if(!this.field_70170_p.field_72995_K) {
         this.func_70052_a(0, this.field_70151_c > 0);
      }

      this.field_70148_d = false;
      this.field_70170_p.field_72984_F.func_76319_b();
   }

   public int func_82145_z() {
      return 0;
   }

   protected void func_70044_A() {
      if(!this.field_70178_ae) {
         this.func_70097_a(DamageSource.field_76371_c, 4.0F);
         this.func_70015_d(15);
      }

   }

   public void func_70015_d(int p_70015_1_) {
      int var2 = p_70015_1_ * 20;
      var2 = EnchantmentProtection.func_92093_a(this, var2);
      if(this.field_70151_c < var2) {
         this.field_70151_c = var2;
      }

   }

   public void func_70066_B() {
      this.field_70151_c = 0;
   }

   protected void func_70076_C() {
      this.func_70106_y();
   }

   public boolean func_70038_c(double p_70038_1_, double p_70038_3_, double p_70038_5_) {
      AxisAlignedBB var7 = this.field_70121_D.func_72325_c(p_70038_1_, p_70038_3_, p_70038_5_);
      List var8 = this.field_70170_p.func_72945_a(this, var7);
      return !var8.isEmpty()?false:!this.field_70170_p.func_72953_d(var7);
   }

   public void func_70091_d(double p_70091_1_, double p_70091_3_, double p_70091_5_) {
      if(this.field_70145_X) {
         this.field_70121_D.func_72317_d(p_70091_1_, p_70091_3_, p_70091_5_);
         this.field_70165_t = (this.field_70121_D.field_72340_a + this.field_70121_D.field_72336_d) / 2.0D;
         this.field_70163_u = this.field_70121_D.field_72338_b + (double)this.field_70129_M - (double)this.field_70139_V;
         this.field_70161_v = (this.field_70121_D.field_72339_c + this.field_70121_D.field_72334_f) / 2.0D;
      } else {
         this.field_70170_p.field_72984_F.func_76320_a("move");
         this.field_70139_V *= 0.4F;
         double var7 = this.field_70165_t;
         double var9 = this.field_70163_u;
         double var11 = this.field_70161_v;
         if(this.field_70134_J) {
            this.field_70134_J = false;
            p_70091_1_ *= 0.25D;
            p_70091_3_ *= 0.05000000074505806D;
            p_70091_5_ *= 0.25D;
            this.field_70159_w = 0.0D;
            this.field_70181_x = 0.0D;
            this.field_70179_y = 0.0D;
         }

         double var13 = p_70091_1_;
         double var15 = p_70091_3_;
         double var17 = p_70091_5_;
         AxisAlignedBB var19 = this.field_70121_D.func_72329_c();
         boolean var20 = this.field_70122_E && this.func_70093_af() && this instanceof EntityPlayer;
         if(var20) {
            double var21;
            for(var21 = 0.05D; p_70091_1_ != 0.0D && this.field_70170_p.func_72945_a(this, this.field_70121_D.func_72325_c(p_70091_1_, -1.0D, 0.0D)).isEmpty(); var13 = p_70091_1_) {
               if(p_70091_1_ < var21 && p_70091_1_ >= -var21) {
                  p_70091_1_ = 0.0D;
               } else if(p_70091_1_ > 0.0D) {
                  p_70091_1_ -= var21;
               } else {
                  p_70091_1_ += var21;
               }
            }

            for(; p_70091_5_ != 0.0D && this.field_70170_p.func_72945_a(this, this.field_70121_D.func_72325_c(0.0D, -1.0D, p_70091_5_)).isEmpty(); var17 = p_70091_5_) {
               if(p_70091_5_ < var21 && p_70091_5_ >= -var21) {
                  p_70091_5_ = 0.0D;
               } else if(p_70091_5_ > 0.0D) {
                  p_70091_5_ -= var21;
               } else {
                  p_70091_5_ += var21;
               }
            }

            while(p_70091_1_ != 0.0D && p_70091_5_ != 0.0D && this.field_70170_p.func_72945_a(this, this.field_70121_D.func_72325_c(p_70091_1_, -1.0D, p_70091_5_)).isEmpty()) {
               if(p_70091_1_ < var21 && p_70091_1_ >= -var21) {
                  p_70091_1_ = 0.0D;
               } else if(p_70091_1_ > 0.0D) {
                  p_70091_1_ -= var21;
               } else {
                  p_70091_1_ += var21;
               }

               if(p_70091_5_ < var21 && p_70091_5_ >= -var21) {
                  p_70091_5_ = 0.0D;
               } else if(p_70091_5_ > 0.0D) {
                  p_70091_5_ -= var21;
               } else {
                  p_70091_5_ += var21;
               }

               var13 = p_70091_1_;
               var17 = p_70091_5_;
            }
         }

         List var36 = this.field_70170_p.func_72945_a(this, this.field_70121_D.func_72321_a(p_70091_1_, p_70091_3_, p_70091_5_));

         for(int var22 = 0; var22 < var36.size(); ++var22) {
            p_70091_3_ = ((AxisAlignedBB)var36.get(var22)).func_72323_b(this.field_70121_D, p_70091_3_);
         }

         this.field_70121_D.func_72317_d(0.0D, p_70091_3_, 0.0D);
         if(!this.field_70135_K && var15 != p_70091_3_) {
            p_70091_5_ = 0.0D;
            p_70091_3_ = 0.0D;
            p_70091_1_ = 0.0D;
         }

         boolean var37 = this.field_70122_E || var15 != p_70091_3_ && var15 < 0.0D;

         int var23;
         for(var23 = 0; var23 < var36.size(); ++var23) {
            p_70091_1_ = ((AxisAlignedBB)var36.get(var23)).func_72316_a(this.field_70121_D, p_70091_1_);
         }

         this.field_70121_D.func_72317_d(p_70091_1_, 0.0D, 0.0D);
         if(!this.field_70135_K && var13 != p_70091_1_) {
            p_70091_5_ = 0.0D;
            p_70091_3_ = 0.0D;
            p_70091_1_ = 0.0D;
         }

         for(var23 = 0; var23 < var36.size(); ++var23) {
            p_70091_5_ = ((AxisAlignedBB)var36.get(var23)).func_72322_c(this.field_70121_D, p_70091_5_);
         }

         this.field_70121_D.func_72317_d(0.0D, 0.0D, p_70091_5_);
         if(!this.field_70135_K && var17 != p_70091_5_) {
            p_70091_5_ = 0.0D;
            p_70091_3_ = 0.0D;
            p_70091_1_ = 0.0D;
         }

         double var25;
         double var27;
         int var30;
         double var38;
         if(this.field_70138_W > 0.0F && var37 && (var20 || this.field_70139_V < 0.05F) && (var13 != p_70091_1_ || var17 != p_70091_5_)) {
            var38 = p_70091_1_;
            var25 = p_70091_3_;
            var27 = p_70091_5_;
            p_70091_1_ = var13;
            p_70091_3_ = (double)this.field_70138_W;
            p_70091_5_ = var17;
            AxisAlignedBB var29 = this.field_70121_D.func_72329_c();
            this.field_70121_D.func_72328_c(var19);
            var36 = this.field_70170_p.func_72945_a(this, this.field_70121_D.func_72321_a(var13, p_70091_3_, var17));

            for(var30 = 0; var30 < var36.size(); ++var30) {
               p_70091_3_ = ((AxisAlignedBB)var36.get(var30)).func_72323_b(this.field_70121_D, p_70091_3_);
            }

            this.field_70121_D.func_72317_d(0.0D, p_70091_3_, 0.0D);
            if(!this.field_70135_K && var15 != p_70091_3_) {
               p_70091_5_ = 0.0D;
               p_70091_3_ = 0.0D;
               p_70091_1_ = 0.0D;
            }

            for(var30 = 0; var30 < var36.size(); ++var30) {
               p_70091_1_ = ((AxisAlignedBB)var36.get(var30)).func_72316_a(this.field_70121_D, p_70091_1_);
            }

            this.field_70121_D.func_72317_d(p_70091_1_, 0.0D, 0.0D);
            if(!this.field_70135_K && var13 != p_70091_1_) {
               p_70091_5_ = 0.0D;
               p_70091_3_ = 0.0D;
               p_70091_1_ = 0.0D;
            }

            for(var30 = 0; var30 < var36.size(); ++var30) {
               p_70091_5_ = ((AxisAlignedBB)var36.get(var30)).func_72322_c(this.field_70121_D, p_70091_5_);
            }

            this.field_70121_D.func_72317_d(0.0D, 0.0D, p_70091_5_);
            if(!this.field_70135_K && var17 != p_70091_5_) {
               p_70091_5_ = 0.0D;
               p_70091_3_ = 0.0D;
               p_70091_1_ = 0.0D;
            }

            if(!this.field_70135_K && var15 != p_70091_3_) {
               p_70091_5_ = 0.0D;
               p_70091_3_ = 0.0D;
               p_70091_1_ = 0.0D;
            } else {
               p_70091_3_ = (double)(-this.field_70138_W);

               for(var30 = 0; var30 < var36.size(); ++var30) {
                  p_70091_3_ = ((AxisAlignedBB)var36.get(var30)).func_72323_b(this.field_70121_D, p_70091_3_);
               }

               this.field_70121_D.func_72317_d(0.0D, p_70091_3_, 0.0D);
            }

            if(var38 * var38 + var27 * var27 >= p_70091_1_ * p_70091_1_ + p_70091_5_ * p_70091_5_) {
               p_70091_1_ = var38;
               p_70091_3_ = var25;
               p_70091_5_ = var27;
               this.field_70121_D.func_72328_c(var29);
            }
         }

         this.field_70170_p.field_72984_F.func_76319_b();
         this.field_70170_p.field_72984_F.func_76320_a("rest");
         this.field_70165_t = (this.field_70121_D.field_72340_a + this.field_70121_D.field_72336_d) / 2.0D;
         this.field_70163_u = this.field_70121_D.field_72338_b + (double)this.field_70129_M - (double)this.field_70139_V;
         this.field_70161_v = (this.field_70121_D.field_72339_c + this.field_70121_D.field_72334_f) / 2.0D;
         this.field_70123_F = var13 != p_70091_1_ || var17 != p_70091_5_;
         this.field_70124_G = var15 != p_70091_3_;
         this.field_70122_E = var15 != p_70091_3_ && var15 < 0.0D;
         this.field_70132_H = this.field_70123_F || this.field_70124_G;
         this.func_70064_a(p_70091_3_, this.field_70122_E);
         if(var13 != p_70091_1_) {
            this.field_70159_w = 0.0D;
         }

         if(var15 != p_70091_3_) {
            this.field_70181_x = 0.0D;
         }

         if(var17 != p_70091_5_) {
            this.field_70179_y = 0.0D;
         }

         var38 = this.field_70165_t - var7;
         var25 = this.field_70163_u - var9;
         var27 = this.field_70161_v - var11;
         if(this.func_70041_e_() && !var20 && this.field_70154_o == null) {
            int var39 = MathHelper.func_76128_c(this.field_70165_t);
            var30 = MathHelper.func_76128_c(this.field_70163_u - 0.20000000298023224D - (double)this.field_70129_M);
            int var31 = MathHelper.func_76128_c(this.field_70161_v);
            Block var32 = this.field_70170_p.func_147439_a(var39, var30, var31);
            int var33 = this.field_70170_p.func_147439_a(var39, var30 - 1, var31).func_149645_b();
            if(var33 == 11 || var33 == 32 || var33 == 21) {
               var32 = this.field_70170_p.func_147439_a(var39, var30 - 1, var31);
            }

            if(var32 != Blocks.field_150468_ap) {
               var25 = 0.0D;
            }

            this.field_70140_Q = (float)((double)this.field_70140_Q + (double)MathHelper.func_76133_a(var38 * var38 + var27 * var27) * 0.6D);
            this.field_82151_R = (float)((double)this.field_82151_R + (double)MathHelper.func_76133_a(var38 * var38 + var25 * var25 + var27 * var27) * 0.6D);
            if(this.field_82151_R > (float)this.field_70150_b && var32.func_149688_o() != Material.field_151579_a) {
               this.field_70150_b = (int)this.field_82151_R + 1;
               if(this.func_70090_H()) {
                  float var34 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w * 0.20000000298023224D + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y * 0.20000000298023224D) * 0.35F;
                  if(var34 > 1.0F) {
                     var34 = 1.0F;
                  }

                  this.func_85030_a(this.func_145776_H(), var34, 1.0F + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.4F);
               }

               this.func_145780_a(var39, var30, var31, var32);
               var32.func_149724_b(this.field_70170_p, var39, var30, var31, this);
            }
         }

         try {
            this.func_145775_I();
         } catch (Throwable var35) {
            CrashReport var41 = CrashReport.func_85055_a(var35, "Checking entity block collision");
            CrashReportCategory var42 = var41.func_85058_a("Entity being checked for collision");
            this.func_85029_a(var42);
            throw new ReportedException(var41);
         }

         boolean var40 = this.func_70026_G();
         if(this.field_70170_p.func_147470_e(this.field_70121_D.func_72331_e(0.001D, 0.001D, 0.001D))) {
            this.func_70081_e(1);
            if(!var40) {
               ++this.field_70151_c;
               if(this.field_70151_c == 0) {
                  this.func_70015_d(8);
               }
            }
         } else if(this.field_70151_c <= 0) {
            this.field_70151_c = -this.field_70174_ab;
         }

         if(var40 && this.field_70151_c > 0) {
            this.func_85030_a("random.fizz", 0.7F, 1.6F + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.4F);
            this.field_70151_c = -this.field_70174_ab;
         }

         this.field_70170_p.field_72984_F.func_76319_b();
      }
   }

   protected String func_145776_H() {
      return "game.neutral.swim";
   }

   protected void func_145775_I() {
      int var1 = MathHelper.func_76128_c(this.field_70121_D.field_72340_a + 0.001D);
      int var2 = MathHelper.func_76128_c(this.field_70121_D.field_72338_b + 0.001D);
      int var3 = MathHelper.func_76128_c(this.field_70121_D.field_72339_c + 0.001D);
      int var4 = MathHelper.func_76128_c(this.field_70121_D.field_72336_d - 0.001D);
      int var5 = MathHelper.func_76128_c(this.field_70121_D.field_72337_e - 0.001D);
      int var6 = MathHelper.func_76128_c(this.field_70121_D.field_72334_f - 0.001D);
      if(this.field_70170_p.func_72904_c(var1, var2, var3, var4, var5, var6)) {
         for(int var7 = var1; var7 <= var4; ++var7) {
            for(int var8 = var2; var8 <= var5; ++var8) {
               for(int var9 = var3; var9 <= var6; ++var9) {
                  Block var10 = this.field_70170_p.func_147439_a(var7, var8, var9);

                  try {
                     var10.func_149670_a(this.field_70170_p, var7, var8, var9, this);
                  } catch (Throwable var14) {
                     CrashReport var12 = CrashReport.func_85055_a(var14, "Colliding entity with block");
                     CrashReportCategory var13 = var12.func_85058_a("Block being collided with");
                     CrashReportCategory.func_147153_a(var13, var7, var8, var9, var10, this.field_70170_p.func_72805_g(var7, var8, var9));
                     throw new ReportedException(var12);
                  }
               }
            }
         }
      }

   }

   protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
      Block.SoundType var5 = p_145780_4_.field_149762_H;
      if(this.field_70170_p.func_147439_a(p_145780_1_, p_145780_2_ + 1, p_145780_3_) == Blocks.field_150431_aC) {
         var5 = Blocks.field_150431_aC.field_149762_H;
         this.func_85030_a(var5.func_150498_e(), var5.func_150497_c() * 0.15F, var5.func_150494_d());
      } else if(!p_145780_4_.func_149688_o().func_76224_d()) {
         this.func_85030_a(var5.func_150498_e(), var5.func_150497_c() * 0.15F, var5.func_150494_d());
      }

   }

   public void func_85030_a(String p_85030_1_, float p_85030_2_, float p_85030_3_) {
      this.field_70170_p.func_72956_a(this, p_85030_1_, p_85030_2_, p_85030_3_);
   }

   protected boolean func_70041_e_() {
      return true;
   }

   protected void func_70064_a(double p_70064_1_, boolean p_70064_3_) {
      if(p_70064_3_) {
         if(this.field_70143_R > 0.0F) {
            this.func_70069_a(this.field_70143_R);
            this.field_70143_R = 0.0F;
         }
      } else if(p_70064_1_ < 0.0D) {
         this.field_70143_R = (float)((double)this.field_70143_R - p_70064_1_);
      }

   }

   public AxisAlignedBB func_70046_E() {
      return null;
   }

   protected void func_70081_e(int p_70081_1_) {
      if(!this.field_70178_ae) {
         this.func_70097_a(DamageSource.field_76372_a, (float)p_70081_1_);
      }

   }

   public final boolean func_70045_F() {
      return this.field_70178_ae;
   }

   protected void func_70069_a(float p_70069_1_) {
      if(this.field_70153_n != null) {
         this.field_70153_n.func_70069_a(p_70069_1_);
      }

   }

   public boolean func_70026_G() {
      return this.field_70171_ac || this.field_70170_p.func_72951_B(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v)) || this.field_70170_p.func_72951_B(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u + (double)this.field_70131_O), MathHelper.func_76128_c(this.field_70161_v));
   }

   public boolean func_70090_H() {
      return this.field_70171_ac;
   }

   public boolean func_70072_I() {
      if(this.field_70170_p.func_72918_a(this.field_70121_D.func_72314_b(0.0D, -0.4000000059604645D, 0.0D).func_72331_e(0.001D, 0.001D, 0.001D), Material.field_151586_h, this)) {
         if(!this.field_70171_ac && !this.field_70148_d) {
            float var1 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w * 0.20000000298023224D + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y * 0.20000000298023224D) * 0.2F;
            if(var1 > 1.0F) {
               var1 = 1.0F;
            }

            this.func_85030_a(this.func_145777_O(), var1, 1.0F + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.4F);
            float var2 = (float)MathHelper.func_76128_c(this.field_70121_D.field_72338_b);

            int var3;
            float var4;
            float var5;
            for(var3 = 0; (float)var3 < 1.0F + this.field_70130_N * 20.0F; ++var3) {
               var4 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * this.field_70130_N;
               var5 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * this.field_70130_N;
               this.field_70170_p.func_72869_a("bubble", this.field_70165_t + (double)var4, (double)(var2 + 1.0F), this.field_70161_v + (double)var5, this.field_70159_w, this.field_70181_x - (double)(this.field_70146_Z.nextFloat() * 0.2F), this.field_70179_y);
            }

            for(var3 = 0; (float)var3 < 1.0F + this.field_70130_N * 20.0F; ++var3) {
               var4 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * this.field_70130_N;
               var5 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * this.field_70130_N;
               this.field_70170_p.func_72869_a("splash", this.field_70165_t + (double)var4, (double)(var2 + 1.0F), this.field_70161_v + (double)var5, this.field_70159_w, this.field_70181_x, this.field_70179_y);
            }
         }

         this.field_70143_R = 0.0F;
         this.field_70171_ac = true;
         this.field_70151_c = 0;
      } else {
         this.field_70171_ac = false;
      }

      return this.field_70171_ac;
   }

   protected String func_145777_O() {
      return "game.neutral.swim.splash";
   }

   public boolean func_70055_a(Material p_70055_1_) {
      double var2 = this.field_70163_u + (double)this.func_70047_e();
      int var4 = MathHelper.func_76128_c(this.field_70165_t);
      int var5 = MathHelper.func_76141_d((float)MathHelper.func_76128_c(var2));
      int var6 = MathHelper.func_76128_c(this.field_70161_v);
      Block var7 = this.field_70170_p.func_147439_a(var4, var5, var6);
      if(var7.func_149688_o() == p_70055_1_) {
         float var8 = BlockLiquid.func_149801_b(this.field_70170_p.func_72805_g(var4, var5, var6)) - 0.11111111F;
         float var9 = (float)(var5 + 1) - var8;
         return var2 < (double)var9;
      } else {
         return false;
      }
   }

   public float func_70047_e() {
      return 0.0F;
   }

   public boolean func_70058_J() {
      return this.field_70170_p.func_72875_a(this.field_70121_D.func_72314_b(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), Material.field_151587_i);
   }

   public void func_70060_a(float p_70060_1_, float p_70060_2_, float p_70060_3_) {
      float var4 = p_70060_1_ * p_70060_1_ + p_70060_2_ * p_70060_2_;
      if(var4 >= 1.0E-4F) {
         var4 = MathHelper.func_76129_c(var4);
         if(var4 < 1.0F) {
            var4 = 1.0F;
         }

         var4 = p_70060_3_ / var4;
         p_70060_1_ *= var4;
         p_70060_2_ *= var4;
         float var5 = MathHelper.func_76126_a(this.field_70177_z * 3.1415927F / 180.0F);
         float var6 = MathHelper.func_76134_b(this.field_70177_z * 3.1415927F / 180.0F);
         this.field_70159_w += (double)(p_70060_1_ * var6 - p_70060_2_ * var5);
         this.field_70179_y += (double)(p_70060_2_ * var6 + p_70060_1_ * var5);
      }
   }

   public float func_70013_c(float p_70013_1_) {
      int var2 = MathHelper.func_76128_c(this.field_70165_t);
      int var3 = MathHelper.func_76128_c(this.field_70161_v);
      if(this.field_70170_p.func_72899_e(var2, 0, var3)) {
         double var4 = (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * 0.66D;
         int var6 = MathHelper.func_76128_c(this.field_70163_u - (double)this.field_70129_M + var4);
         return this.field_70170_p.func_72801_o(var2, var6, var3);
      } else {
         return 0.0F;
      }
   }

   public void func_70029_a(World p_70029_1_) {
      this.field_70170_p = p_70029_1_;
   }

   public void func_70080_a(double p_70080_1_, double p_70080_3_, double p_70080_5_, float p_70080_7_, float p_70080_8_) {
      this.field_70169_q = this.field_70165_t = p_70080_1_;
      this.field_70167_r = this.field_70163_u = p_70080_3_;
      this.field_70166_s = this.field_70161_v = p_70080_5_;
      this.field_70126_B = this.field_70177_z = p_70080_7_;
      this.field_70127_C = this.field_70125_A = p_70080_8_;
      this.field_70139_V = 0.0F;
      double var9 = (double)(this.field_70126_B - p_70080_7_);
      if(var9 < -180.0D) {
         this.field_70126_B += 360.0F;
      }

      if(var9 >= 180.0D) {
         this.field_70126_B -= 360.0F;
      }

      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.func_70101_b(p_70080_7_, p_70080_8_);
   }

   public void func_70012_b(double p_70012_1_, double p_70012_3_, double p_70012_5_, float p_70012_7_, float p_70012_8_) {
      this.field_70142_S = this.field_70169_q = this.field_70165_t = p_70012_1_;
      this.field_70137_T = this.field_70167_r = this.field_70163_u = p_70012_3_ + (double)this.field_70129_M;
      this.field_70136_U = this.field_70166_s = this.field_70161_v = p_70012_5_;
      this.field_70177_z = p_70012_7_;
      this.field_70125_A = p_70012_8_;
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
   }

   public float func_70032_d(Entity p_70032_1_) {
      float var2 = (float)(this.field_70165_t - p_70032_1_.field_70165_t);
      float var3 = (float)(this.field_70163_u - p_70032_1_.field_70163_u);
      float var4 = (float)(this.field_70161_v - p_70032_1_.field_70161_v);
      return MathHelper.func_76129_c(var2 * var2 + var3 * var3 + var4 * var4);
   }

   public double func_70092_e(double p_70092_1_, double p_70092_3_, double p_70092_5_) {
      double var7 = this.field_70165_t - p_70092_1_;
      double var9 = this.field_70163_u - p_70092_3_;
      double var11 = this.field_70161_v - p_70092_5_;
      return var7 * var7 + var9 * var9 + var11 * var11;
   }

   public double func_70011_f(double p_70011_1_, double p_70011_3_, double p_70011_5_) {
      double var7 = this.field_70165_t - p_70011_1_;
      double var9 = this.field_70163_u - p_70011_3_;
      double var11 = this.field_70161_v - p_70011_5_;
      return (double)MathHelper.func_76133_a(var7 * var7 + var9 * var9 + var11 * var11);
   }

   public double func_70068_e(Entity p_70068_1_) {
      double var2 = this.field_70165_t - p_70068_1_.field_70165_t;
      double var4 = this.field_70163_u - p_70068_1_.field_70163_u;
      double var6 = this.field_70161_v - p_70068_1_.field_70161_v;
      return var2 * var2 + var4 * var4 + var6 * var6;
   }

   public void func_70100_b_(EntityPlayer p_70100_1_) {}

   public void func_70108_f(Entity p_70108_1_) {
      if(p_70108_1_.field_70153_n != this && p_70108_1_.field_70154_o != this) {
         double var2 = p_70108_1_.field_70165_t - this.field_70165_t;
         double var4 = p_70108_1_.field_70161_v - this.field_70161_v;
         double var6 = MathHelper.func_76132_a(var2, var4);
         if(var6 >= 0.009999999776482582D) {
            var6 = (double)MathHelper.func_76133_a(var6);
            var2 /= var6;
            var4 /= var6;
            double var8 = 1.0D / var6;
            if(var8 > 1.0D) {
               var8 = 1.0D;
            }

            var2 *= var8;
            var4 *= var8;
            var2 *= 0.05000000074505806D;
            var4 *= 0.05000000074505806D;
            var2 *= (double)(1.0F - this.field_70144_Y);
            var4 *= (double)(1.0F - this.field_70144_Y);
            this.func_70024_g(-var2, 0.0D, -var4);
            p_70108_1_.func_70024_g(var2, 0.0D, var4);
         }

      }
   }

   public void func_70024_g(double p_70024_1_, double p_70024_3_, double p_70024_5_) {
      this.field_70159_w += p_70024_1_;
      this.field_70181_x += p_70024_3_;
      this.field_70179_y += p_70024_5_;
      this.field_70160_al = true;
   }

   protected void func_70018_K() {
      this.field_70133_I = true;
   }

   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
      if(this.func_85032_ar()) {
         return false;
      } else {
         this.func_70018_K();
         return false;
      }
   }

   public boolean func_70067_L() {
      return false;
   }

   public boolean func_70104_M() {
      return false;
   }

   public void func_70084_c(Entity p_70084_1_, int p_70084_2_) {}

   public boolean func_98035_c(NBTTagCompound p_98035_1_) {
      String var2 = this.func_70022_Q();
      if(!this.field_70128_L && var2 != null) {
         p_98035_1_.func_74778_a("id", var2);
         this.func_70109_d(p_98035_1_);
         return true;
      } else {
         return false;
      }
   }

   public boolean func_70039_c(NBTTagCompound p_70039_1_) {
      String var2 = this.func_70022_Q();
      if(!this.field_70128_L && var2 != null && this.field_70153_n == null) {
         p_70039_1_.func_74778_a("id", var2);
         this.func_70109_d(p_70039_1_);
         return true;
      } else {
         return false;
      }
   }

   public void func_70109_d(NBTTagCompound p_70109_1_) {
      try {
         p_70109_1_.func_74782_a("Pos", this.func_70087_a(new double[]{this.field_70165_t, this.field_70163_u + (double)this.field_70139_V, this.field_70161_v}));
         p_70109_1_.func_74782_a("Motion", this.func_70087_a(new double[]{this.field_70159_w, this.field_70181_x, this.field_70179_y}));
         p_70109_1_.func_74782_a("Rotation", this.func_70049_a(new float[]{this.field_70177_z, this.field_70125_A}));
         p_70109_1_.func_74776_a("FallDistance", this.field_70143_R);
         p_70109_1_.func_74777_a("Fire", (short)this.field_70151_c);
         p_70109_1_.func_74777_a("Air", (short)this.func_70086_ai());
         p_70109_1_.func_74757_a("OnGround", this.field_70122_E);
         p_70109_1_.func_74768_a("Dimension", this.field_71093_bK);
         p_70109_1_.func_74757_a("Invulnerable", this.field_83001_bt);
         p_70109_1_.func_74768_a("PortalCooldown", this.field_71088_bW);
         p_70109_1_.func_74772_a("UUIDMost", this.func_110124_au().getMostSignificantBits());
         p_70109_1_.func_74772_a("UUIDLeast", this.func_110124_au().getLeastSignificantBits());
         this.func_70014_b(p_70109_1_);
         if(this.field_70154_o != null) {
            NBTTagCompound var2 = new NBTTagCompound();
            if(this.field_70154_o.func_98035_c(var2)) {
               p_70109_1_.func_74782_a("Riding", var2);
            }
         }

      } catch (Throwable var5) {
         CrashReport var3 = CrashReport.func_85055_a(var5, "Saving entity NBT");
         CrashReportCategory var4 = var3.func_85058_a("Entity being saved");
         this.func_85029_a(var4);
         throw new ReportedException(var3);
      }
   }

   public void func_70020_e(NBTTagCompound p_70020_1_) {
      try {
         NBTTagList var2 = p_70020_1_.func_150295_c("Pos", 6);
         NBTTagList var6 = p_70020_1_.func_150295_c("Motion", 6);
         NBTTagList var7 = p_70020_1_.func_150295_c("Rotation", 5);
         this.field_70159_w = var6.func_150309_d(0);
         this.field_70181_x = var6.func_150309_d(1);
         this.field_70179_y = var6.func_150309_d(2);
         if(Math.abs(this.field_70159_w) > 10.0D) {
            this.field_70159_w = 0.0D;
         }

         if(Math.abs(this.field_70181_x) > 10.0D) {
            this.field_70181_x = 0.0D;
         }

         if(Math.abs(this.field_70179_y) > 10.0D) {
            this.field_70179_y = 0.0D;
         }

         this.field_70169_q = this.field_70142_S = this.field_70165_t = var2.func_150309_d(0);
         this.field_70167_r = this.field_70137_T = this.field_70163_u = var2.func_150309_d(1);
         this.field_70166_s = this.field_70136_U = this.field_70161_v = var2.func_150309_d(2);
         this.field_70126_B = this.field_70177_z = var7.func_150308_e(0);
         this.field_70127_C = this.field_70125_A = var7.func_150308_e(1);
         this.field_70143_R = p_70020_1_.func_74760_g("FallDistance");
         this.field_70151_c = p_70020_1_.func_74765_d("Fire");
         this.func_70050_g(p_70020_1_.func_74765_d("Air"));
         this.field_70122_E = p_70020_1_.func_74767_n("OnGround");
         this.field_71093_bK = p_70020_1_.func_74762_e("Dimension");
         this.field_83001_bt = p_70020_1_.func_74767_n("Invulnerable");
         this.field_71088_bW = p_70020_1_.func_74762_e("PortalCooldown");
         if(p_70020_1_.func_150297_b("UUIDMost", 4) && p_70020_1_.func_150297_b("UUIDLeast", 4)) {
            this.field_96093_i = new UUID(p_70020_1_.func_74763_f("UUIDMost"), p_70020_1_.func_74763_f("UUIDLeast"));
         }

         this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
         this.func_70101_b(this.field_70177_z, this.field_70125_A);
         this.func_70037_a(p_70020_1_);
         if(this.func_142008_O()) {
            this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
         }

      } catch (Throwable var5) {
         CrashReport var3 = CrashReport.func_85055_a(var5, "Loading entity NBT");
         CrashReportCategory var4 = var3.func_85058_a("Entity being loaded");
         this.func_85029_a(var4);
         throw new ReportedException(var3);
      }
   }

   protected boolean func_142008_O() {
      return true;
   }

   protected final String func_70022_Q() {
      return EntityList.func_75621_b(this);
   }

   protected abstract void func_70037_a(NBTTagCompound var1);

   protected abstract void func_70014_b(NBTTagCompound var1);

   public void func_110123_P() {}

   protected NBTTagList func_70087_a(double ... p_70087_1_) {
      NBTTagList var2 = new NBTTagList();
      double[] var3 = p_70087_1_;
      int var4 = p_70087_1_.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         double var6 = var3[var5];
         var2.func_74742_a(new NBTTagDouble(var6));
      }

      return var2;
   }

   protected NBTTagList func_70049_a(float ... p_70049_1_) {
      NBTTagList var2 = new NBTTagList();
      float[] var3 = p_70049_1_;
      int var4 = p_70049_1_.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         float var6 = var3[var5];
         var2.func_74742_a(new NBTTagFloat(var6));
      }

      return var2;
   }

   public EntityItem func_145779_a(Item p_145779_1_, int p_145779_2_) {
      return this.func_145778_a(p_145779_1_, p_145779_2_, 0.0F);
   }

   public EntityItem func_145778_a(Item p_145778_1_, int p_145778_2_, float p_145778_3_) {
      return this.func_70099_a(new ItemStack(p_145778_1_, p_145778_2_, 0), p_145778_3_);
   }

   public EntityItem func_70099_a(ItemStack p_70099_1_, float p_70099_2_) {
      if(p_70099_1_.field_77994_a != 0 && p_70099_1_.func_77973_b() != null) {
         EntityItem var3 = new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u + (double)p_70099_2_, this.field_70161_v, p_70099_1_);
         var3.field_145804_b = 10;
         this.field_70170_p.func_72838_d(var3);
         return var3;
      } else {
         return null;
      }
   }

   public boolean func_70089_S() {
      return !this.field_70128_L;
   }

   public boolean func_70094_T() {
      for(int var1 = 0; var1 < 8; ++var1) {
         float var2 = ((float)((var1 >> 0) % 2) - 0.5F) * this.field_70130_N * 0.8F;
         float var3 = ((float)((var1 >> 1) % 2) - 0.5F) * 0.1F;
         float var4 = ((float)((var1 >> 2) % 2) - 0.5F) * this.field_70130_N * 0.8F;
         int var5 = MathHelper.func_76128_c(this.field_70165_t + (double)var2);
         int var6 = MathHelper.func_76128_c(this.field_70163_u + (double)this.func_70047_e() + (double)var3);
         int var7 = MathHelper.func_76128_c(this.field_70161_v + (double)var4);
         if(this.field_70170_p.func_147439_a(var5, var6, var7).func_149721_r()) {
            return true;
         }
      }

      return false;
   }

   public boolean func_130002_c(EntityPlayer p_130002_1_) {
      return false;
   }

   public AxisAlignedBB func_70114_g(Entity p_70114_1_) {
      return null;
   }

   public void func_70098_U() {
      if(this.field_70154_o.field_70128_L) {
         this.field_70154_o = null;
      } else {
         this.field_70159_w = 0.0D;
         this.field_70181_x = 0.0D;
         this.field_70179_y = 0.0D;
         this.func_70071_h_();
         if(this.field_70154_o != null) {
            this.field_70154_o.func_70043_V();
            this.field_70147_f += (double)(this.field_70154_o.field_70177_z - this.field_70154_o.field_70126_B);

            for(this.field_70149_e += (double)(this.field_70154_o.field_70125_A - this.field_70154_o.field_70127_C); this.field_70147_f >= 180.0D; this.field_70147_f -= 360.0D) {
               ;
            }

            while(this.field_70147_f < -180.0D) {
               this.field_70147_f += 360.0D;
            }

            while(this.field_70149_e >= 180.0D) {
               this.field_70149_e -= 360.0D;
            }

            while(this.field_70149_e < -180.0D) {
               this.field_70149_e += 360.0D;
            }

            double var1 = this.field_70147_f * 0.5D;
            double var3 = this.field_70149_e * 0.5D;
            float var5 = 10.0F;
            if(var1 > (double)var5) {
               var1 = (double)var5;
            }

            if(var1 < (double)(-var5)) {
               var1 = (double)(-var5);
            }

            if(var3 > (double)var5) {
               var3 = (double)var5;
            }

            if(var3 < (double)(-var5)) {
               var3 = (double)(-var5);
            }

            this.field_70147_f -= var1;
            this.field_70149_e -= var3;
         }
      }
   }

   public void func_70043_V() {
      if(this.field_70153_n != null) {
         this.field_70153_n.func_70107_b(this.field_70165_t, this.field_70163_u + this.func_70042_X() + this.field_70153_n.func_70033_W(), this.field_70161_v);
      }
   }

   public double func_70033_W() {
      return (double)this.field_70129_M;
   }

   public double func_70042_X() {
      return (double)this.field_70131_O * 0.75D;
   }

   public void func_70078_a(Entity p_70078_1_) {
      this.field_70149_e = 0.0D;
      this.field_70147_f = 0.0D;
      if(p_70078_1_ == null) {
         if(this.field_70154_o != null) {
            this.func_70012_b(this.field_70154_o.field_70165_t, this.field_70154_o.field_70121_D.field_72338_b + (double)this.field_70154_o.field_70131_O, this.field_70154_o.field_70161_v, this.field_70177_z, this.field_70125_A);
            this.field_70154_o.field_70153_n = null;
         }

         this.field_70154_o = null;
      } else {
         if(this.field_70154_o != null) {
            this.field_70154_o.field_70153_n = null;
         }

         if(p_70078_1_ != null) {
            for(Entity var2 = p_70078_1_.field_70154_o; var2 != null; var2 = var2.field_70154_o) {
               if(var2 == this) {
                  return;
               }
            }
         }

         this.field_70154_o = p_70078_1_;
         p_70078_1_.field_70153_n = this;
      }
   }

   public float func_70111_Y() {
      return 0.1F;
   }

   public Vec3 func_70040_Z() {
      return null;
   }

   public void func_70063_aa() {
      if(this.field_71088_bW > 0) {
         this.field_71088_bW = this.func_82147_ab();
      } else {
         double var1 = this.field_70169_q - this.field_70165_t;
         double var3 = this.field_70166_s - this.field_70161_v;
         if(!this.field_70170_p.field_72995_K && !this.field_71087_bX) {
            this.field_82152_aq = Direction.func_82372_a(var1, var3);
         }

         this.field_71087_bX = true;
      }
   }

   public int func_82147_ab() {
      return 300;
   }

   public ItemStack[] func_70035_c() {
      return null;
   }

   public void func_70062_b(int p_70062_1_, ItemStack p_70062_2_) {}

   public boolean func_70027_ad() {
      boolean var1 = this.field_70170_p != null && this.field_70170_p.field_72995_K;
      return !this.field_70178_ae && (this.field_70151_c > 0 || var1 && this.func_70083_f(0));
   }

   public boolean func_70115_ae() {
      return this.field_70154_o != null;
   }

   public boolean func_70093_af() {
      return this.func_70083_f(1);
   }

   public void func_70095_a(boolean p_70095_1_) {
      this.func_70052_a(1, p_70095_1_);
   }

   public boolean func_70051_ag() {
      return this.func_70083_f(3);
   }

   public void func_70031_b(boolean p_70031_1_) {
      this.func_70052_a(3, p_70031_1_);
   }

   public boolean func_82150_aj() {
      return this.func_70083_f(5);
   }

   public void func_82142_c(boolean p_82142_1_) {
      this.func_70052_a(5, p_82142_1_);
   }

   public void func_70019_c(boolean p_70019_1_) {
      this.func_70052_a(4, p_70019_1_);
   }

   protected boolean func_70083_f(int p_70083_1_) {
      return (this.field_70180_af.func_75683_a(0) & 1 << p_70083_1_) != 0;
   }

   protected void func_70052_a(int p_70052_1_, boolean p_70052_2_) {
      byte var3 = this.field_70180_af.func_75683_a(0);
      if(p_70052_2_) {
         this.field_70180_af.func_75692_b(0, Byte.valueOf((byte)(var3 | 1 << p_70052_1_)));
      } else {
         this.field_70180_af.func_75692_b(0, Byte.valueOf((byte)(var3 & ~(1 << p_70052_1_))));
      }

   }

   public int func_70086_ai() {
      return this.field_70180_af.func_75693_b(1);
   }

   public void func_70050_g(int p_70050_1_) {
      this.field_70180_af.func_75692_b(1, Short.valueOf((short)p_70050_1_));
   }

   public void func_70077_a(EntityLightningBolt p_70077_1_) {
      this.func_70081_e(5);
      ++this.field_70151_c;
      if(this.field_70151_c == 0) {
         this.func_70015_d(8);
      }

   }

   public void func_70074_a(EntityLivingBase p_70074_1_) {}

   protected boolean func_145771_j(double p_145771_1_, double p_145771_3_, double p_145771_5_) {
      int var7 = MathHelper.func_76128_c(p_145771_1_);
      int var8 = MathHelper.func_76128_c(p_145771_3_);
      int var9 = MathHelper.func_76128_c(p_145771_5_);
      double var10 = p_145771_1_ - (double)var7;
      double var12 = p_145771_3_ - (double)var8;
      double var14 = p_145771_5_ - (double)var9;
      List var16 = this.field_70170_p.func_147461_a(this.field_70121_D);
      if(var16.isEmpty() && !this.field_70170_p.func_147469_q(var7, var8, var9)) {
         return false;
      } else {
         boolean var17 = !this.field_70170_p.func_147469_q(var7 - 1, var8, var9);
         boolean var18 = !this.field_70170_p.func_147469_q(var7 + 1, var8, var9);
         boolean var19 = !this.field_70170_p.func_147469_q(var7, var8 - 1, var9);
         boolean var20 = !this.field_70170_p.func_147469_q(var7, var8 + 1, var9);
         boolean var21 = !this.field_70170_p.func_147469_q(var7, var8, var9 - 1);
         boolean var22 = !this.field_70170_p.func_147469_q(var7, var8, var9 + 1);
         byte var23 = 3;
         double var24 = 9999.0D;
         if(var17 && var10 < var24) {
            var24 = var10;
            var23 = 0;
         }

         if(var18 && 1.0D - var10 < var24) {
            var24 = 1.0D - var10;
            var23 = 1;
         }

         if(var20 && 1.0D - var12 < var24) {
            var24 = 1.0D - var12;
            var23 = 3;
         }

         if(var21 && var14 < var24) {
            var24 = var14;
            var23 = 4;
         }

         if(var22 && 1.0D - var14 < var24) {
            var24 = 1.0D - var14;
            var23 = 5;
         }

         float var26 = this.field_70146_Z.nextFloat() * 0.2F + 0.1F;
         if(var23 == 0) {
            this.field_70159_w = (double)(-var26);
         }

         if(var23 == 1) {
            this.field_70159_w = (double)var26;
         }

         if(var23 == 2) {
            this.field_70181_x = (double)(-var26);
         }

         if(var23 == 3) {
            this.field_70181_x = (double)var26;
         }

         if(var23 == 4) {
            this.field_70179_y = (double)(-var26);
         }

         if(var23 == 5) {
            this.field_70179_y = (double)var26;
         }

         return true;
      }
   }

   public void func_70110_aj() {
      this.field_70134_J = true;
      this.field_70143_R = 0.0F;
   }

   public String func_70005_c_() {
      String var1 = EntityList.func_75621_b(this);
      if(var1 == null) {
         var1 = "generic";
      }

      return StatCollector.func_74838_a("entity." + var1 + ".name");
   }

   public Entity[] func_70021_al() {
      return null;
   }

   public boolean func_70028_i(Entity p_70028_1_) {
      return this == p_70028_1_;
   }

   public float func_70079_am() {
      return 0.0F;
   }

   public boolean func_70075_an() {
      return true;
   }

   public boolean func_85031_j(Entity p_85031_1_) {
      return false;
   }

   public String toString() {
      return String.format("%s[\'%s\'/%d, l=\'%s\', x=%.2f, y=%.2f, z=%.2f]", new Object[]{this.getClass().getSimpleName(), this.func_70005_c_(), Integer.valueOf(this.field_145783_c), this.field_70170_p == null?"~NULL~":this.field_70170_p.func_72912_H().func_76065_j(), Double.valueOf(this.field_70165_t), Double.valueOf(this.field_70163_u), Double.valueOf(this.field_70161_v)});
   }

   public boolean func_85032_ar() {
      return this.field_83001_bt;
   }

   public void func_82149_j(Entity p_82149_1_) {
      this.func_70012_b(p_82149_1_.field_70165_t, p_82149_1_.field_70163_u, p_82149_1_.field_70161_v, p_82149_1_.field_70177_z, p_82149_1_.field_70125_A);
   }

   public void func_82141_a(Entity p_82141_1_, boolean p_82141_2_) {
      NBTTagCompound var3 = new NBTTagCompound();
      p_82141_1_.func_70109_d(var3);
      this.func_70020_e(var3);
      this.field_71088_bW = p_82141_1_.field_71088_bW;
      this.field_82152_aq = p_82141_1_.field_82152_aq;
   }

   public void func_71027_c(int p_71027_1_) {
      if(!this.field_70170_p.field_72995_K && !this.field_70128_L) {
         this.field_70170_p.field_72984_F.func_76320_a("changeDimension");
         MinecraftServer var2 = MinecraftServer.func_71276_C();
         int var3 = this.field_71093_bK;
         WorldServer var4 = var2.func_71218_a(var3);
         WorldServer var5 = var2.func_71218_a(p_71027_1_);
         this.field_71093_bK = p_71027_1_;
         if(var3 == 1 && p_71027_1_ == 1) {
            var5 = var2.func_71218_a(0);
            this.field_71093_bK = 0;
         }

         this.field_70170_p.func_72900_e(this);
         this.field_70128_L = false;
         this.field_70170_p.field_72984_F.func_76320_a("reposition");
         var2.func_71203_ab().func_82448_a(this, var3, var4, var5);
         this.field_70170_p.field_72984_F.func_76318_c("reloading");
         Entity var6 = EntityList.func_75620_a(EntityList.func_75621_b(this), var5);
         if(var6 != null) {
            var6.func_82141_a(this, true);
            if(var3 == 1 && p_71027_1_ == 1) {
               ChunkCoordinates var7 = var5.func_72861_E();
               var7.field_71572_b = this.field_70170_p.func_72825_h(var7.field_71574_a, var7.field_71573_c);
               var6.func_70012_b((double)var7.field_71574_a, (double)var7.field_71572_b, (double)var7.field_71573_c, var6.field_70177_z, var6.field_70125_A);
            }

            var5.func_72838_d(var6);
         }

         this.field_70128_L = true;
         this.field_70170_p.field_72984_F.func_76319_b();
         var4.func_82742_i();
         var5.func_82742_i();
         this.field_70170_p.field_72984_F.func_76319_b();
      }
   }

   public float func_145772_a(Explosion p_145772_1_, World p_145772_2_, int p_145772_3_, int p_145772_4_, int p_145772_5_, Block p_145772_6_) {
      return p_145772_6_.func_149638_a(this);
   }

   public boolean func_145774_a(Explosion p_145774_1_, World p_145774_2_, int p_145774_3_, int p_145774_4_, int p_145774_5_, Block p_145774_6_, float p_145774_7_) {
      return true;
   }

   public int func_82143_as() {
      return 3;
   }

   public int func_82148_at() {
      return this.field_82152_aq;
   }

   public boolean func_145773_az() {
      return false;
   }

   public void func_85029_a(CrashReportCategory p_85029_1_) {
      p_85029_1_.func_71500_a("Entity Type", new Callable() {

         private static final String __OBFID = "CL_00001534";

         public String call() {
            return EntityList.func_75621_b(Entity.this) + " (" + Entity.this.getClass().getCanonicalName() + ")";
         }
         // $FF: synthetic method
         public Object call() {
            return this.call();
         }
      });
      p_85029_1_.func_71507_a("Entity ID", Integer.valueOf(this.field_145783_c));
      p_85029_1_.func_71500_a("Entity Name", new Callable() {

         private static final String __OBFID = "CL_00001535";

         public String call() {
            return Entity.this.func_70005_c_();
         }
         // $FF: synthetic method
         public Object call() {
            return this.call();
         }
      });
      p_85029_1_.func_71507_a("Entity\'s Exact location", String.format("%.2f, %.2f, %.2f", new Object[]{Double.valueOf(this.field_70165_t), Double.valueOf(this.field_70163_u), Double.valueOf(this.field_70161_v)}));
      p_85029_1_.func_71507_a("Entity\'s Block location", CrashReportCategory.func_85071_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v)));
      p_85029_1_.func_71507_a("Entity\'s Momentum", String.format("%.2f, %.2f, %.2f", new Object[]{Double.valueOf(this.field_70159_w), Double.valueOf(this.field_70181_x), Double.valueOf(this.field_70179_y)}));
   }

   public UUID func_110124_au() {
      return this.field_96093_i;
   }

   public boolean func_96092_aw() {
      return true;
   }

   public IChatComponent func_145748_c_() {
      return new ChatComponentText(this.func_70005_c_());
   }

   public void func_145781_i(int p_145781_1_) {}

   public static enum EnumEntitySize {

      SIZE_1("SIZE_1", 0),
      SIZE_2("SIZE_2", 1),
      SIZE_3("SIZE_3", 2),
      SIZE_4("SIZE_4", 3),
      SIZE_5("SIZE_5", 4),
      SIZE_6("SIZE_6", 5);
      // $FF: synthetic field
      private static final Entity.EnumEntitySize[] $VALUES = new Entity.EnumEntitySize[]{SIZE_1, SIZE_2, SIZE_3, SIZE_4, SIZE_5, SIZE_6};
      private static final String __OBFID = "CL_00001537";


      private EnumEntitySize(String p_i1581_1_, int p_i1581_2_) {}

      public int func_75630_a(double p_75630_1_) {
         double var3 = p_75630_1_ - ((double)MathHelper.func_76128_c(p_75630_1_) + 0.5D);
         switch(Entity.SwitchEnumEntitySize.field_96565_a[this.ordinal()]) {
         case 1:
            if(var3 < 0.0D) {
               if(var3 < -0.3125D) {
                  return MathHelper.func_76143_f(p_75630_1_ * 32.0D);
               }
            } else if(var3 < 0.3125D) {
               return MathHelper.func_76143_f(p_75630_1_ * 32.0D);
            }

            return MathHelper.func_76128_c(p_75630_1_ * 32.0D);
         case 2:
            if(var3 < 0.0D) {
               if(var3 < -0.3125D) {
                  return MathHelper.func_76128_c(p_75630_1_ * 32.0D);
               }
            } else if(var3 < 0.3125D) {
               return MathHelper.func_76128_c(p_75630_1_ * 32.0D);
            }

            return MathHelper.func_76143_f(p_75630_1_ * 32.0D);
         case 3:
            if(var3 > 0.0D) {
               return MathHelper.func_76128_c(p_75630_1_ * 32.0D);
            }

            return MathHelper.func_76143_f(p_75630_1_ * 32.0D);
         case 4:
            if(var3 < 0.0D) {
               if(var3 < -0.1875D) {
                  return MathHelper.func_76143_f(p_75630_1_ * 32.0D);
               }
            } else if(var3 < 0.1875D) {
               return MathHelper.func_76143_f(p_75630_1_ * 32.0D);
            }

            return MathHelper.func_76128_c(p_75630_1_ * 32.0D);
         case 5:
            if(var3 < 0.0D) {
               if(var3 < -0.1875D) {
                  return MathHelper.func_76128_c(p_75630_1_ * 32.0D);
               }
            } else if(var3 < 0.1875D) {
               return MathHelper.func_76128_c(p_75630_1_ * 32.0D);
            }

            return MathHelper.func_76143_f(p_75630_1_ * 32.0D);
         case 6:
         default:
            if(var3 > 0.0D) {
               return MathHelper.func_76143_f(p_75630_1_ * 32.0D);
            } else {
               return MathHelper.func_76128_c(p_75630_1_ * 32.0D);
            }
         }
      }

   }

   // $FF: synthetic class
   static final class SwitchEnumEntitySize {

      // $FF: synthetic field
      static final int[] field_96565_a = new int[Entity.EnumEntitySize.values().length];
      private static final String __OBFID = "CL_00001536";


      static {
         try {
            field_96565_a[Entity.EnumEntitySize.SIZE_1.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            field_96565_a[Entity.EnumEntitySize.SIZE_2.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            field_96565_a[Entity.EnumEntitySize.SIZE_3.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            field_96565_a[Entity.EnumEntitySize.SIZE_4.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_96565_a[Entity.EnumEntitySize.SIZE_5.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_96565_a[Entity.EnumEntitySize.SIZE_6.ordinal()] = 6;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
