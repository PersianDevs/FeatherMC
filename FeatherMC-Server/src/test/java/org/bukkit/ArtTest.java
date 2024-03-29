package org.bukkit;

import com.google.common.collect.Lists;
import net.minecraft.server.EntityPainting.EnumArt;
import org.bukkit.craftbukkit.CraftArt;
import org.junit.Test;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class ArtTest {
    private static final int UNIT_MULTIPLIER = 16;

    @Test
    public void verifyMapping() {
        List<Art> arts = Lists.newArrayList(Art.values());

        for (EnumArt enumArt : EnumArt.values()) {
            int id = enumArt.ordinal();
            String name = enumArt.B;
            int width = enumArt.C / UNIT_MULTIPLIER;
            int height = enumArt.D / UNIT_MULTIPLIER;

            Art subject = Art.getById(id);

            String message = String.format("org.bukkit.Art is missing id: %d named: '%s'", id, name);
            assertNotNull(message, subject);

            assertThat(Art.getByName(name), is(subject));
            assertThat("Art." + subject + "'s width", subject.getBlockWidth(), is(width));
            assertThat("Art." + subject + "'s height", subject.getBlockHeight(), is(height));

            arts.remove(subject);
        }

        assertThat("org.bukkit.Art has too many arts", arts, is(Collections.EMPTY_LIST));
    }

    @Test
    public void testCraftArtToNotch() {
        Map<EnumArt, Art> cache = new EnumMap(EnumArt.class);
        for (Art art : Art.values()) {
            EnumArt enumArt = CraftArt.BukkitToNotch(art);
            assertNotNull(art.name(), enumArt);
            assertThat(art.name(), cache.put(enumArt, art), is(nullValue()));
        }
    }

    @Test
    public void testCraftArtToBukkit() {
        Map<Art, EnumArt> cache = new EnumMap(Art.class);
        for (EnumArt enumArt : EnumArt.values()) {
            Art art = CraftArt.NotchToBukkit(enumArt);
            assertNotNull(enumArt.name(), art);
            assertThat(enumArt.name(), cache.put(art, enumArt), is(nullValue()));
        }
    }
}
