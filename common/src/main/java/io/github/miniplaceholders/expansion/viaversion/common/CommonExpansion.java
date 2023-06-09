package io.github.miniplaceholders.expansion.viaversion.common;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.ViaAPI;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import io.github.miniplaceholders.api.Expansion;
import net.kyori.adventure.identity.Identity;
import net.kyori.adventure.text.minimessage.tag.Tag;

public final class CommonExpansion {
    public static Expansion.Builder builder() {
        final ViaAPI<?> api = Via.getAPI();
        return Expansion.builder("viaversion")
                .audiencePlaceholder("player_protocol_version", (aud, queue, ctx) -> {
                    final ProtocolVersion version = aud.get(Identity.UUID)
                            .map(api::getPlayerVersion)
                            .map(ProtocolVersion::getProtocol)
                            .orElse(ProtocolVersion.unknown);
                    return Tag.preProcessParsed(version.getName());
                })
                .audiencePlaceholder("player_protocol_id", (aud, queue, ctx) -> {
                    final int id = aud.get(Identity.UUID)
                            .map(api::getPlayerVersion)
                            .orElse(-1);
                    return Tag.preProcessParsed(Integer.toString(id));
                });
    }
}
