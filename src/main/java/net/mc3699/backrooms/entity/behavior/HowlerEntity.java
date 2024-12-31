package net.mc3699.backrooms.entity.behavior;

import foundry.veil.api.client.render.light.PointLight;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

public class HowlerEntity extends Monster {

    private Player targetPlayer;


    public HowlerEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new StalkPlayerGoal(this));
    }

    public static AttributeSupplier.Builder createHowlerAttributes()
    {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20D)
                .add(Attributes.MOVEMENT_SPEED, .5D)
                .add(Attributes.ATTACK_DAMAGE, 10.0D)
                .add(Attributes.ARMOR, 1.0D)
                .add(Attributes.FOLLOW_RANGE, 100D);
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }

    private class StalkPlayerGoal extends Goal
    {
        private final Monster mob;

        private StalkPlayerGoal(Monster mob) {
            this.mob = mob;
        }
        @Override
        public boolean canUse() {
            targetPlayer = mob.level().getNearestPlayer(mob, 100d);
            return targetPlayer != null && targetPlayer.isAlive();
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
                navigation.moveTo(targetPlayer, 0.8f);
            } else {
                mob.getNavigation().stop();
            }
        }
    }
}
