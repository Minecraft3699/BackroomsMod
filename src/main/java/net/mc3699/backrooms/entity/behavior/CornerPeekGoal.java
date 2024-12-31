package net.mc3699.backrooms.entity.behavior;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;

public class CornerPeekGoal extends Goal {

    private static final double MAX_DISTANCE = 30;
    
    public CornerPeekGoal(Monster mob) {
        this.mob = mob;
    }

    private final Monster mob;
    private Player targetPlayer;

    @Override
    public boolean canUse() {
        return false;
    }

    @Override
    public void start() {
        mob.getNavigation().stop();
    }

    @Override
    public void tick() {
        if(targetPlayer != null)
        {
            mob.getLookControl().setLookAt(targetPlayer, 10f,10f);
            PathNavigation navigation = mob.getNavigation();
            navigation.moveTo(targetPlayer, 0.4f);
        } else {
            mob.getNavigation().stop();
        }
    }
}
