package talent.bearers.slimefusion.common.block

import net.minecraft.block.properties.PropertyEnum
import net.minecraft.block.state.BlockStateContainer
import net.minecraft.block.state.IBlockState
import talent.bearers.slimefusion.common.block.base.BlockModLog
import talent.bearers.slimefusion.common.block.base.EnumStringSerializable
import talent.bearers.slimefusion.common.lib.LibNames

/**
 * @author WireSegal
 * Created at 10:01 AM on 12/25/16.
 */
class BlockLogColorful : BlockModLog(LibNames.COLOR_LOG, *VARIANTS) {
    companion object {
        val VARIANTS = arrayOf(
                "snow_log",
                "cherry_log",
                "cotton_log",
                "ember_log"
        )

        val TYPE: PropertyEnum<Type> = PropertyEnum.create("type", Type::class.java)
    }

    enum class Type : EnumStringSerializable {
        SNOW, CHERRY, COTTON, EMBER
    }

    override fun createBlockState(): BlockStateContainer {
        return BlockStateContainer(this, AXIS, TYPE)
    }

    override fun getMetaFromState(state: IBlockState): Int {
        return super.getMetaFromState(state) or state.getValue(TYPE).ordinal
    }

    override fun getStateFromMeta(meta: Int): IBlockState {
        return super.getStateFromMeta(meta).withProperty(TYPE, Type.values()[meta and 3])
    }
}
