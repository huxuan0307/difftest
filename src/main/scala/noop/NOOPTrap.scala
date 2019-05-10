package noop

import chisel3._
import chisel3.util._

object NOOPTrap extends HasDecodeConst {
  def StateGoodTrap  = 0.U
  def StateBadTrap   = 1.U
  def StateInvOpcode = 2.U
  def StateRunning   = 3.U

  def TRAP    = BitPat("b????????????_?????_000_?????_1101011")
  val table = Array(TRAP -> List(InstrI, FuAlu, AluAdd))
}

class Monitor extends BlackBox {
  val io = IO(new Bundle {
    val clk = Input(Clock())
    val isNoopTrap = Input(Bool())
    val trapCode = Input(UInt(32.W))
  })
}
