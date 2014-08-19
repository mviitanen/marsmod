package net.minecraft.scoreboard;

import net.minecraft.scoreboard.IScoreObjectiveCriteria;
import net.minecraft.scoreboard.Scoreboard;

public class ScoreObjective {

   private final Scoreboard field_96686_a;
   private final String field_96684_b;
   private final IScoreObjectiveCriteria field_96685_c;
   private String field_96683_d;
   private static final String __OBFID = "CL_00000614";


   public ScoreObjective(Scoreboard p_i2307_1_, String p_i2307_2_, IScoreObjectiveCriteria p_i2307_3_) {
      this.field_96686_a = p_i2307_1_;
      this.field_96684_b = p_i2307_2_;
      this.field_96685_c = p_i2307_3_;
      this.field_96683_d = p_i2307_2_;
   }

   public String func_96679_b() {
      return this.field_96684_b;
   }

   public IScoreObjectiveCriteria func_96680_c() {
      return this.field_96685_c;
   }

   public String func_96678_d() {
      return this.field_96683_d;
   }

   public void func_96681_a(String p_96681_1_) {
      this.field_96683_d = p_96681_1_;
      this.field_96686_a.func_96532_b(this);
   }
}
