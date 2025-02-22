package de.fraunhofer.aisec.codyze.crymlin

import de.fraunhofer.aisec.codyze.analysis.passes.EdgeCachePass
import de.fraunhofer.aisec.codyze.analysis.passes.IdentifierPass
import de.fraunhofer.aisec.cpg.TranslationConfiguration
import de.fraunhofer.aisec.cpg.TranslationManager
import java.io.File

abstract class AbstractTest {
    companion object {
        /**
         * Helper method for initializing an Analysis Run.
         *
         * @param sourceLocations
         * @return
         */
        @JvmStatic
        protected fun newAnalysisRun(vararg sourceLocations: File): TranslationManager {
            return TranslationManager.builder()
                .config(
                    TranslationConfiguration.builder()
                        .debugParser(true)
                        .failOnError(false)
                        .defaultPasses()
                        .registerPass(IdentifierPass())
                        .registerPass(EdgeCachePass())
                        .defaultLanguages()
                        .sourceLocations(*sourceLocations)
                        .build()
                )
                .build()
        }
    }
}
