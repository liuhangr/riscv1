package utils

import Core.EXU.{ALUOpType, BRUOpType, LSUOpType}
import Core.IDU.{FuncType, InstrType}
import chisel3._
import chisel3.util._

object RV32I_ALUInstr extends InstrType {
  def ADDI    = BitPat("b????????????_?????_000_?????_0010011")
  def SLLI    = BitPat("b000000??????_?????_001_?????_0010011")
  def SLTI    = BitPat("b????????????_?????_010_?????_0010011")
  def SLTIU   = BitPat("b????????????_?????_011_?????_0010011")
  def XORI    = BitPat("b????????????_?????_100_?????_0010011")
  def SRLI    = BitPat("b000000??????_?????_101_?????_0010011")
  def ORI     = BitPat("b????????????_?????_110_?????_0010011")
  def ANDI    = BitPat("b????????????_?????_111_?????_0010011")
  def SRAI    = BitPat("b010000??????_?????_101_?????_0010011")

  def ADD     = BitPat("b0000000_?????_?????_000_?????_0110011")
  def SLL     = BitPat("b0000000_?????_?????_001_?????_0110011")
  def SLT     = BitPat("b0000000_?????_?????_010_?????_0110011")
  def SLTU    = BitPat("b0000000_?????_?????_011_?????_0110011")
  def XOR     = BitPat("b0000000_?????_?????_100_?????_0110011")
  def SRL     = BitPat("b0000000_?????_?????_101_?????_0110011")
  def OR      = BitPat("b0000000_?????_?????_110_?????_0110011")
  def AND     = BitPat("b0000000_?????_?????_111_?????_0110011")
  def SUB     = BitPat("b0100000_?????_?????_000_?????_0110011")
  def SRA     = BitPat("b0100000_?????_?????_101_?????_0110011")

  def AUIPC   = BitPat("b????????????????????_?????_0010111")
  def LUI     = BitPat("b????????????????????_?????_0110111")

  val table = Array(
    ADDI           -> List(InstrI, FuncType.alu, ALUOpType.add),
    SLLI           -> List(InstrI, FuncType.alu, ALUOpType.sll),
    SLTI           -> List(InstrI, FuncType.alu, ALUOpType.slt),
    SLTIU          -> List(InstrI, FuncType.alu, ALUOpType.sltu),
    XORI           -> List(InstrI, FuncType.alu, ALUOpType.xor),
    SRLI           -> List(InstrI, FuncType.alu, ALUOpType.srl),
    ORI            -> List(InstrI, FuncType.alu, ALUOpType.or ),
    ANDI           -> List(InstrI, FuncType.alu, ALUOpType.and),
    SRAI           -> List(InstrI, FuncType.alu, ALUOpType.sra),

    ADD            -> List(InstrR, FuncType.alu, ALUOpType.add),
    SLL            -> List(InstrR, FuncType.alu, ALUOpType.sll),
    SLT            -> List(InstrR, FuncType.alu, ALUOpType.slt),
    SLTU           -> List(InstrR, FuncType.alu, ALUOpType.sltu),
    XOR            -> List(InstrR, FuncType.alu, ALUOpType.xor),
    SRL            -> List(InstrR, FuncType.alu, ALUOpType.srl),
    OR             -> List(InstrR, FuncType.alu, ALUOpType.or ),
    AND            -> List(InstrR, FuncType.alu, ALUOpType.and),
    SUB            -> List(InstrR, FuncType.alu, ALUOpType.sub),
    SRA            -> List(InstrR, FuncType.alu, ALUOpType.sra),

    AUIPC          -> List(InstrU, FuncType.alu, ALUOpType.add),
    LUI            -> List(InstrU, FuncType.alu, ALUOpType.lui)
  )
}

object RV32I_BRUInstr extends InstrType {
  def JAL     = BitPat("b????????????????????_?????_1101111")
  def JALR    = BitPat("b????????????_?????_000_?????_1100111")

  def BNE     = BitPat("b???????_?????_?????_001_?????_1100011")
  def BEQ     = BitPat("b???????_?????_?????_000_?????_1100011")
  def BLT     = BitPat("b???????_?????_?????_100_?????_1100011")
  def BGE     = BitPat("b???????_?????_?????_101_?????_1100011")
  def BLTU    = BitPat("b???????_?????_?????_110_?????_1100011")
  def BGEU    = BitPat("b???????_?????_?????_111_?????_1100011")

  val table = Array(
    JAL            -> List(InstrJ, FuncType.bru, BRUOpType.jal),
    JALR           -> List(InstrI, FuncType.bru, BRUOpType.jalr),

    BEQ            -> List(InstrB, FuncType.bru, BRUOpType.beq),
    BNE            -> List(InstrB, FuncType.bru, BRUOpType.bne),
    BLT            -> List(InstrB, FuncType.bru, BRUOpType.blt),
    BGE            -> List(InstrB, FuncType.bru, BRUOpType.bge),
    BLTU           -> List(InstrB, FuncType.bru, BRUOpType.bltu),
    BGEU           -> List(InstrB, FuncType.bru, BRUOpType.bgeu)
  )
}

object RV32I_LSUInstr extends InstrType {
  def LB      = BitPat("b????????????_?????_000_?????_0000011")
  def LH      = BitPat("b????????????_?????_001_?????_0000011")
  def LW      = BitPat("b????????????_?????_010_?????_0000011")
  def LBU     = BitPat("b????????????_?????_100_?????_0000011")
  def LHU     = BitPat("b????????????_?????_101_?????_0000011")
  def SB      = BitPat("b???????_?????_?????_000_?????_0100011")
  def SH      = BitPat("b???????_?????_?????_001_?????_0100011")
  def SW      = BitPat("b???????_?????_?????_010_?????_0100011")

  val table = Array(
    LB             -> List(InstrI, FuncType.lsu, LSUOpType.lb ),
    LH             -> List(InstrI, FuncType.lsu, LSUOpType.lh ),
    LW             -> List(InstrI, FuncType.lsu, LSUOpType.lw ),
    LBU            -> List(InstrI, FuncType.lsu, LSUOpType.lbu),
    LHU            -> List(InstrI, FuncType.lsu, LSUOpType.lhu),
    SB             -> List(InstrS, FuncType.lsu, LSUOpType.sb ),
    SH             -> List(InstrS, FuncType.lsu, LSUOpType.sh ),
    SW             -> List(InstrS, FuncType.lsu, LSUOpType.sw)
  )
}

object RV64IInstr extends InstrType {
  def ADDIW   = BitPat("b???????_?????_?????_000_?????_0011011")
  def SLLIW   = BitPat("b0000000_?????_?????_001_?????_0011011")
  def SRLIW   = BitPat("b0000000_?????_?????_101_?????_0011011")
  def SRAIW   = BitPat("b0100000_?????_?????_101_?????_0011011")
  def SLLW    = BitPat("b0000000_?????_?????_001_?????_0111011")
  def SRLW    = BitPat("b0000000_?????_?????_101_?????_0111011")
  def SRAW    = BitPat("b0100000_?????_?????_101_?????_0111011")
  def ADDW    = BitPat("b0000000_?????_?????_000_?????_0111011")
  def SUBW    = BitPat("b0100000_?????_?????_000_?????_0111011")

  def LWU     = BitPat("b???????_?????_?????_110_?????_0000011")
  def LD      = BitPat("b???????_?????_?????_011_?????_0000011")
  def SD      = BitPat("b???????_?????_?????_011_?????_0100011")

  val table = Array(
    ADDIW          -> List(InstrI, FuncType.alu, ALUOpType.addw),
    SLLIW          -> List(InstrI, FuncType.alu, ALUOpType.sllw),
    SRLIW          -> List(InstrI, FuncType.alu, ALUOpType.srlw),
    SRAIW          -> List(InstrI, FuncType.alu, ALUOpType.sraw),
    SLLW           -> List(InstrR, FuncType.alu, ALUOpType.sllw),
    SRLW           -> List(InstrR, FuncType.alu, ALUOpType.srlw),
    SRAW           -> List(InstrR, FuncType.alu, ALUOpType.sraw),
    ADDW           -> List(InstrR, FuncType.alu, ALUOpType.addw),
    SUBW           -> List(InstrR, FuncType.alu, ALUOpType.subw),

    LWU            -> List(InstrI, FuncType.lsu, LSUOpType.lwu),
    LD             -> List(InstrI, FuncType.lsu, LSUOpType.ld ),
    SD             -> List(InstrS, FuncType.lsu, LSUOpType.sd)
  )
}

object RVIInstr extends InstrType {
  val table = RV32I_ALUInstr.table ++ RV32I_BRUInstr.table ++ RV32I_LSUInstr.table ++ RV64IInstr.table
  val defaultTable = List(InstrN, FuncType.alu, ALUOpType.add)
}