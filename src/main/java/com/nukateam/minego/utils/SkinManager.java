package com.nukateam.minego.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nukateam.minego.MinecraftGo;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimplePreparableReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Mod.EventBusSubscriber(modid = MinecraftGo.MOD_ID)
public class SkinManager extends SimplePreparableReloadListener<Map<String, SkinsCollection>> {
    private static SkinManager instance;
    static Map<String, SkinsCollection> collectionList = new HashMap<>();


    @Override
    protected Map<String, SkinsCollection> prepare(ResourceManager resourceManager, ProfilerFiller profilerFiller) {
        return loadData(resourceManager);
    }
    public static SkinsCollection getCollection(String name) {
        return collectionList.get(name);
    }

    @Override
    protected void apply(Map<String, SkinsCollection> stringPipBoyArchivesMap, ResourceManager resourceManager, ProfilerFiller profilerFiller) {
    }

    public Map<String, SkinsCollection> loadData(ResourceManager manager) {
        collectionList.clear();
        Map<ResourceLocation, Resource> resources = manager.listResources(
                "cases",
                location -> location.getPath().endsWith(".json")
        );
        for (Map.Entry<ResourceLocation, Resource> entry : resources.entrySet()) {
            ResourceLocation location = entry.getKey();
            Resource resource = entry.getValue();
            String fileName = getFileNameFromLocation(location);

            try (InputStream inputStream = resource.open();
                 Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {

                JsonObject json = JsonParser.parseReader(reader).getAsJsonObject();

                JsonObject entriesJson = json.getAsJsonObject("skins");
                //String name = json.has("name") ? json.get("name").getAsString() : fileName;
                SkinsCollection collection = new SkinsCollection(fileName);

                for (Map.Entry<String, JsonElement> entryElement : entriesJson.entrySet()) {
                    JsonObject entryData = entryElement.getValue().getAsJsonObject();

                    GunSkin skin = new GunSkin(
                            entryData.get("gun").getAsString(),
                            entryData.get("rarity").getAsString(),
                            entryData.get("skin_name").getAsString(),
                            entryData.get("contracted").getAsBoolean(),
                            entryData.get("secret").getAsBoolean(),
                            entryData.get("wear_type").getAsString()
                    );
                    collection.addEntry(skin);

                }
                collectionList.put(fileName, collection);

            } catch (IOException e) {
                MinecraftGo.LOGGER.error("Failed to load pipboy archive: {}", location, e);
            }
        }

        return collectionList;
    }


    @SubscribeEvent
    public static void addReloadListenerEvent(AddReloadListenerEvent event) {
        SkinManager manager = new SkinManager();
        event.addListener(manager);
        instance = manager;
    }

    private static String getFileNameFromLocation(ResourceLocation location) {
        String path = location.getPath();
        path = path.substring("cases/".length(), path.length() - 5);
        return path.replace('/', '.');
    }


    public static Style setRarityColor(String rarity) {
        switch (rarity) {
            case "consumer" : return Style.EMPTY.withColor(0xe1e8f0);
            case "basic" : return Style.EMPTY.withColor(0xb0c3d9);
            case "common" : return Style.EMPTY.withColor(0x4b69ff);
            case "uncommon" : return Style.EMPTY.withColor(0x8847ff);
            case "rare" : return Style.EMPTY.withColor(0xd32ce6);
            case "ultra_rare" : return Style.EMPTY.withColor(0xeb4b4b);
            case "contraband" : return Style.EMPTY.withColor(0xffc815);
            case "limited" : return Style.EMPTY.withColor(0xf6c976);
            case "prototype" : return Style.EMPTY.withColor(0x58c815);
            default: return Style.EMPTY.withColor(0xe1e8f0);
        }
    }
    public static int setRarityAlphaColor(String rarity) {
        switch (rarity) {
            case "consumer" : return 0xFFe1e8f0;
            case "basic" : return 0xFFb0c3d9;
            case "common" : return 0xFF4b69ff;
            case "uncommon" : return 0xFF8847ff;
            case "rare" : return 0xFFd32ce6;
            case "ultra_rare" : return 0xFFeb4b4b;
            case "contraband" : return 0xFFffc815;
            case "limited" : return 0xFFf6c976;
            case "prototype" : return 0xFF58c815;
            default: return 0xFFe1e8f0;
        }
    }

    public static boolean containsCollection(String fileName) {
        return collectionList.containsKey(fileName);
    }


    public static Set<String> getAllFileNames() {
        return collectionList.keySet();
    }

    public static int getCollectionsCount() {
        return collectionList.size();
    }
}
