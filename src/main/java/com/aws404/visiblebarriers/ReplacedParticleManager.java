package com.aws404.visiblebarriers;

import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ReplacedParticleManager extends ParticleManager {
    public ReplacedParticleManager(World worldIn, TextureManager rendererIn) {
        super(worldIn, rendererIn);
    }

    @Nullable
    public Particle spawnEffectParticle(int particleId, double xCoord, double yCoord, double zCoord, double xSpeed, double ySpeed, double zSpeed, int... parameters) {
        if (particleId == 35 && NewCustomBarrierBlock.IS_SHOWING)
            return null;

        return super.spawnEffectParticle(particleId, xCoord, yCoord, zCoord, xSpeed, ySpeed, zSpeed, parameters);

    }
}
