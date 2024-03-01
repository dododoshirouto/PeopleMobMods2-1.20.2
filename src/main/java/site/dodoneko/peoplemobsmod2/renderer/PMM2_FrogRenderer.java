package site.dodoneko.peoplemobsmod2.renderer;

import java.util.Map;

import com.google.common.collect.Maps;

import net.minecraft.Util;
import net.minecraft.client.model.FrogModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.FrogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.FrogVariant;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import site.dodoneko.peoplemobsmod2.PeopleMobsMod2;
import site.dodoneko.peoplemobsmod2.base.PMM2_HumanoidMobRenderer;
import site.dodoneko.peoplemobsmod2.model.PMM2_FrogModel;

@OnlyIn(Dist.CLIENT)
public class PMM2_FrogRenderer<T extends Frog> extends PMM2_HumanoidMobRenderer<Frog, PMM2_FrogModel> {

    FrogRenderer refR;
    FrogModel<Frog> refM;

    @SuppressWarnings({ "null" })
    private static final Map<FrogVariant, ResourceLocation> TEXTURES = Util.make(Maps.newHashMap(),
            (entity) -> {
                entity.put(FrogVariant.TEMPERATE,
                        new ResourceLocation("textures/entity/frog/temperate_frog-chan.png"));
                entity.put(FrogVariant.COLD,
                        new ResourceLocation("textures/entity/frog/cold_frog-chan.png"));
                entity.put(FrogVariant.WARM,
                        new ResourceLocation("textures/entity/frog/warm_frog-chan.png"));
            });

    // model options
    public static float modelScale = 0.9F;
    public static float bHeight = 0.3F;
    public static boolean useChildModel = false;
    public static boolean doFlyFlap = false;
    public static boolean forwardArm = false;
    public static boolean isFloating = false;
    public static float floatingHeight = 0.0F;
    public static boolean doWalkBounding = true;

    @SuppressWarnings("null")
    public PMM2_FrogRenderer(EntityRendererProvider.Context entity) {
        super(entity, new PMM2_FrogModel(entity.bakeLayer(PeopleMobsMod2.PMM2_HUMANOID_LAYER)), modelScale);
        this.getModel().modelScale = modelScale;
        this.getModel().bHeight = bHeight;
        this.getModel().useChildModel = useChildModel;
        this.getModel().doFlyFlap = doFlyFlap;
        this.getModel().forwardArm = forwardArm;
        this.getModel().isFloating = isFloating;
        this.getModel().floatingHeight = floatingHeight;
        this.getModel().doWalkBounding = doWalkBounding;
    }

    public static void setModelScales(float scale, float height) {
        modelScale = scale;
        bHeight = height;
    }

    public static void setModelScales(float scale, float height, boolean isChild) {
        modelScale = scale;
        bHeight = height;
        useChildModel = isChild;
    }

    public static void setModelScales(float scale, float height, boolean isChild, boolean flyFlap) {
        modelScale = scale;
        bHeight = height;
        useChildModel = isChild;
        doFlyFlap = flyFlap;
    }

    public static void setForwardArm(boolean v) {
        forwardArm = v;
    }

    public static void setIsFloating(boolean v, float h) {
        isFloating = v;
        floatingHeight = h;
    }

    public static void setDoWalkBounding(boolean v) {
        doWalkBounding = v;
    }
    

    @Override
    public ResourceLocation getTextureLocation(Frog entity) {
        return TEXTURES.get(entity.getVariant());
    }
}