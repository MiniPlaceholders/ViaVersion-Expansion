package io.github.miniplaceholders.expansion.viaversion;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.ViaAPI;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import io.github.miniplaceholders.api.Expansion;
import io.github.miniplaceholders.api.provider.ExpansionProvider;
import io.github.miniplaceholders.api.provider.LoadRequirement;
import net.kyori.adventure.identity.Identity;
import net.kyori.adventure.text.minimessage.tag.Tag;

public final class ViaVersionExpansionProvider implements ExpansionProvider {

    @Override
    public Expansion provideExpansion() {
        return ViaVersionExpansion.viaversion();
    }

    @Override
    public LoadRequirement loadRequirement() {
        return LoadRequirement.requiredComplement("viaversion", "ViaVersion");
    }

    static final class ViaVersionExpansion {
        private ViaVersionExpansion() {}

        static Expansion viaversion() {
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
                    }).build();
        }
    }
}
