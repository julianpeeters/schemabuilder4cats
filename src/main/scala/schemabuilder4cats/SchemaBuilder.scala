package schemabuilder4cats

import _root_.scala.jdk.CollectionConverters.{MapHasAsJava, SeqHasAsJava}
import cats.effect.kernel.Sync
import cats.implicits.given
import java.nio.ByteBuffer
import org.apache.avro.generic.GenericRecord
import org.apache.avro.Schema
import org.apache.avro.SchemaBuilder.{
  ArrayBuilder as JArrayBuilder,
  ArrayDefault as JArrayDefault,
  BaseTypeBuilder as JBaseTypeBuilder,
  BaseFieldTypeBuilder as JBaseFieldTypeBuilder,
  BooleanBuilder as JBooleanBuilder,
  BooleanDefault as JBooleanDefault,
  BytesBuilder as JBytesBuilder,
  BytesDefault as JBytesDefault,
  DoubleBuilder as JDoubleBuilder,
  DoubleDefault as JDoubleDefault,
  EnumBuilder as JEnumBuilder,
  EnumDefault as JEnumDefault,
  FieldAssembler as JFieldAssembler,
  FieldBuilder as JFieldBuilder,
  FieldDefault as JFieldDefault,
  FieldTypeBuilder as JFieldTypeBuilder,
  FixedBuilder as JFixedBuilder,
  FixedDefault as JFixedDefault,
  FloatBuilder as JFloatBuilder,
  FloatDefault as JFloatDefault,
  GenericDefault as JGenericDefault,
  IntBuilder as JIntBuilder,
  IntDefault as JIntDefault,
  LongBuilder as JLongBuilder,
  LongDefault as JLongDefault,
  MapBuilder as JMapBuilder,
  MapDefault as JMapDefault,
  NamedBuilder as JNamedBuilder,
  NamespacedBuilder as JNamespacedBuilder,
  NullBuilder as JNullBuilder,
  NullDefault as JNullDefault,
  PropBuilder as JPropBuilder,
  RecordBuilder as JRecordBuilder,
  RecordDefault as JRecordDefault,
  StringBldr as JStringBuilder,
  StringDefault as JStringDefault,
  TypeBuilder as JTypeBuilder,
  UnionAccumulator as JUnionAccumulator,
  UnionFieldTypeBuilder as JUnionFieldTypeBuilder,
}

// Not implemented: self methods, shortcut methods
trait SchemaBuilder[F[_]]:
  def array: F[JArrayBuilder[Schema]]
  def builder: F[JTypeBuilder[Schema]]
  def builder(namespace: String): F[JTypeBuilder[Schema]]
  def enumeration(name: String): F[JEnumBuilder[Schema]]
  def fixed(name: String): F[JFixedBuilder[Schema]]
  def map: F[JMapBuilder[Schema]]
  def nullable: F[JBaseTypeBuilder[Schema]]
  def record(name: String): F[JRecordBuilder[Schema]]
  def unionOf: F[JBaseTypeBuilder[JUnionAccumulator[Schema]]]
  extension (fab: F[JArrayBuilder[Schema]])
    def items: F[JTypeBuilder[Schema]]
    def items(itemsSchema: Schema): F[Schema]
    @scala.annotation.targetName("propArrayBuilder")
    def prop(name: String, `val`: String): F[JArrayBuilder[Schema]]
  extension (fad: F[JArrayDefault[Schema]])
    def arrayDefault[V](defaultVal: List[V]): F[JFieldAssembler[Schema]]
  extension (fbftb: F[JBaseFieldTypeBuilder[Schema]])
    @scala.annotation.targetName("arrayBuilderBaseFieldTypeBuilder")
    def array: F[JArrayBuilder[JArrayDefault[Schema]]]
    @scala.annotation.targetName("booleanBuilderBaseFieldTypeBuilder")
    def booleanBuilder: F[JBooleanBuilder[JBooleanDefault[Schema]]]
    @scala.annotation.targetName("booleanTypeBaseFieldTypeBuilder")
    def booleanType: F[JBooleanDefault[Schema]]
    @scala.annotation.targetName("bytesBuilderBaseFieldTypeBuilder")
    def bytesBuilder: F[JBytesBuilder[JBytesDefault[Schema]]]
    @scala.annotation.targetName("bytesTypeBaseFieldTypeBuilder")
    def bytesType: F[JBytesDefault[Schema]]
    @scala.annotation.targetName("doubleBuilderBaseFieldTypeBuilder")
    def doubleBuilder: F[JDoubleBuilder[JDoubleDefault[Schema]]]
    @scala.annotation.targetName("doubleTypeBaseFieldTypeBuilder")
    def doubleType: F[JDoubleDefault[Schema]]
    @scala.annotation.targetName("enumerationBaseFieldTypeBuilder")
    def enumeration(name: String): F[JEnumBuilder[JEnumDefault[Schema]]]
    @scala.annotation.targetName("fixedBaseFieldTypeBuilder")
    def fixed(name: String): F[JFixedBuilder[JFixedDefault[Schema]]]
    @scala.annotation.targetName("floatBuilderBaseFieldTypeBuilder")
    def floatBuilder: F[JFloatBuilder[JFloatDefault[Schema]]]
    @scala.annotation.targetName("floatTypeBaseFieldTypeBuilder")
    def floatType: F[JFloatDefault[Schema]]
    @scala.annotation.targetName("intBuilderBaseFieldTypeBuilder")
    def intBuilder: F[JIntBuilder[JIntDefault[Schema]]]
    @scala.annotation.targetName("intTypeBaseFieldTypeBuilder")
    def intType: F[JIntDefault[Schema]]
    @scala.annotation.targetName("longBuilderBaseFieldTypeBuilder")
    def longBuilder: F[JLongBuilder[JLongDefault[Schema]]]
    @scala.annotation.targetName("longTypeBaseFieldTypeBuilder")
    def longType: F[JLongDefault[Schema]]
    @scala.annotation.targetName("mapBaseFieldTypeBuilder")
    def map: F[JMapBuilder[JMapDefault[Schema]]]
    @scala.annotation.targetName("nullBuilderBaseFieldTypeBuilder")
    def nullBuilder: F[JNullBuilder[JNullDefault[Schema]]]
    @scala.annotation.targetName("nullTypeBaseFieldTypeBuilder")
    def nullType: F[JNullDefault[Schema]]
    @scala.annotation.targetName("recordBaseFieldTypeBuilder")
    def record(name: String): F[JRecordBuilder[JRecordDefault[Schema]]]
    @scala.annotation.targetName("stringBuilderBaseFieldTypeBuilder")
    def stringBuilder: F[JStringBuilder[JStringDefault[Schema]]]
    @scala.annotation.targetName("stringTypeBaseFieldTypeBuilder")
    def stringType: F[JStringDefault[Schema]]
  extension (fbtb: F[JBaseTypeBuilder[Schema]])
    @scala.annotation.targetName("arrayBuilderBaseTypeBuilder")
    def array: F[JArrayBuilder[Schema]]
    @scala.annotation.targetName("booleanBuilderBaseTypeBuilder")
    def booleanBuilder: F[JBooleanBuilder[Schema]]
    @scala.annotation.targetName("booleanTypeBaseTypeBuilder")
    def booleanType: F[Schema]
    @scala.annotation.targetName("bytesBuilderBaseTypeBuilder")
    def bytesBuilder: F[JBytesBuilder[Schema]]
    @scala.annotation.targetName("bytesTypeBaseTypeBuilder")
    def bytesType: F[Schema]
    @scala.annotation.targetName("doubleBuilderBaseTypeBuilder")
    def doubleBuilder: F[JDoubleBuilder[Schema]]
    @scala.annotation.targetName("doubleTypeBaseTypeBuilder")
    def doubleType: F[Schema]
    @scala.annotation.targetName("enumerationBaseTypeBuilder")
    def enumeration(name: String): F[JEnumBuilder[Schema]]
    @scala.annotation.targetName("fixedBaseTypeBuilder")
    def fixed(name: String): F[JFixedBuilder[Schema]]
    @scala.annotation.targetName("floatBuilderBaseTypeBuilder")
    def floatBuilder: F[JFloatBuilder[Schema]]
    @scala.annotation.targetName("floatTypeBaseTypeBuilder")
    def floatType: F[Schema]
    @scala.annotation.targetName("intBuilderBaseTypeBuilder")
    def intBuilder: F[JIntBuilder[Schema]]
    @scala.annotation.targetName("intTypeBaseTypeBuilder")
    def intType: F[Schema]
    @scala.annotation.targetName("longBuilderBaseTypeBuilder")
    def longBuilder: F[JLongBuilder[Schema]]
    @scala.annotation.targetName("longTypeBaseTypeBuilder")
    def longType: F[Schema]
    @scala.annotation.targetName("mapBaseTypeBuilder")
    def map: F[JMapBuilder[Schema]]
    @scala.annotation.targetName("nullBuilderBaseTypeBuilder")
    def nullBuilder: F[JNullBuilder[Schema]]
    @scala.annotation.targetName("nullTypeBaseTypeBuilder")
    def nullType: F[Schema]
    @scala.annotation.targetName("recordBaseTypeBuilder")
    def record(name: String): F[JRecordBuilder[Schema]]
    @scala.annotation.targetName("stringBuilderBaseTypeBuilder")
    def stringBuilder: F[JStringBuilder[Schema]]
    @scala.annotation.targetName("stringTypeBaseTypeBuilder")
    def stringType: F[Schema]
    @scala.annotation.targetName("typeSchemaBaseTypeBuilder")
    def `type`(schema: Schema): F[Schema]
    @scala.annotation.targetName("typeNameBaseTypeBuilder")
    def `type`(name: String): F[Schema]
    @scala.annotation.targetName("typeFullNameBaseTypeBuilder")
    def `type`(name: String, namespace: String): F[Schema]
  extension (fbb: F[JBooleanBuilder[Schema]])
    def endBoolean: F[Schema]
    @scala.annotation.targetName("propBooleanBuilder")
    def prop(name: String, `val`: String): F[JBooleanBuilder[Schema]]
  extension (fbd: F[JBooleanDefault[Schema]])
    def booleanDefault(defaultVal: Boolean): F[JFieldAssembler[Schema]]
  extension (fbb: F[JBytesBuilder[Schema]])
    def endBytes: F[Schema]
    @scala.annotation.targetName("propBytesBuilder")
    def prop(name: String, `val`: String): F[JBytesBuilder[Schema]]
  extension (fbd: F[JBytesDefault[Schema]])
    def bytesDefault(defaultVal: Array[Byte]): F[JFieldAssembler[Schema]]
    def bytesDefault(defaultVal: ByteBuffer): F[JFieldAssembler[Schema]]
    def bytesDefault(defaultVal: String): F[JFieldAssembler[Schema]]
  extension (fdb: F[JDoubleBuilder[Schema]])
    def endDouble: F[Schema]
    @scala.annotation.targetName("propDoubleBuilder")
    def prop(name: String, `val`: String): F[JDoubleBuilder[Schema]]
  extension (fdd: F[JDoubleDefault[Schema]])
    def doubleDefault(defaultVal: Double): F[JFieldAssembler[Schema]]
  extension (feb: F[JEnumBuilder[Schema]])
    @scala.annotation.targetName("aliasesEnumBuilder")
    def aliases(aliases: String*): F[JEnumBuilder[Schema]]
    @scala.annotation.targetName("docEnumBuilder")
    def doc(doc: String): F[JEnumBuilder[Schema]]
    @scala.annotation.targetName("namespaceEnumBuilder")
    def namespace(namespace: String): F[JEnumBuilder[Schema]]
    @scala.annotation.targetName("propEnumBuilder")
    def prop(name: String, `val`: String): F[JEnumBuilder[Schema]]
    def symbols(symbols: String*): F[Schema]
  extension (fed: F[JEnumDefault[Schema]])
    def enumDefault(defaultVal: String): F[JFieldAssembler[Schema]]
  extension (ffa: F[JFieldAssembler[Schema]])
    def endRecord: F[Schema]
    def name(fieldName: String): F[JFieldBuilder[Schema]]
  extension (ffb: F[JFieldBuilder[Schema]])
    @scala.annotation.targetName("aliasesFieldBuilder")
    def aliases(aliases: String*): F[JFieldBuilder[Schema]]
    @scala.annotation.targetName("docFieldBuilder")
    def doc(doc: String): F[JFieldBuilder[Schema]]
    def orderAscending: F[JFieldBuilder[Schema]]
    def orderDescending: F[JFieldBuilder[Schema]]
    def orderIgnore: F[JFieldBuilder[Schema]]
    @scala.annotation.targetName("propFieldBuilder")
    def prop(name: String, `val`: String): F[JFieldBuilder[Schema]]
    @scala.annotation.targetName("typeFieldBuilder")
    def `type`: F[JFieldTypeBuilder[Schema]]
  extension (fftb: F[JFieldTypeBuilder[Schema]])
    @scala.annotation.targetName("arrayBuilderFieldTypeBuilder")
    def array: F[JArrayBuilder[JArrayDefault[Schema]]]
    @scala.annotation.targetName("booleanBuilderFieldTypeBuilder")
    def booleanBuilder: F[JBooleanBuilder[JBooleanDefault[Schema]]]
    @scala.annotation.targetName("booleanTypeFieldTypeBuilder")
    def booleanType: F[JBooleanDefault[Schema]]
    @scala.annotation.targetName("bytesBuilderFieldTypeBuilder")
    def bytesBuilder: F[JBytesBuilder[JBytesDefault[Schema]]]
    @scala.annotation.targetName("bytesTypeFieldTypeBuilder")
    def bytesType: F[JBytesDefault[Schema]]
    @scala.annotation.targetName("doubleBuilderFieldTypeBuilder")
    def doubleBuilder: F[JDoubleBuilder[JDoubleDefault[Schema]]]
    @scala.annotation.targetName("doubleTypeFieldTypeBuilder")
    def doubleType: F[JDoubleDefault[Schema]]
    @scala.annotation.targetName("enumerationFieldTypeBuilder")
    def enumeration(name: String): F[JEnumBuilder[JEnumDefault[Schema]]]
    @scala.annotation.targetName("fixedFieldTypeBuilder")
    def fixed(name: String): F[JFixedBuilder[JFixedDefault[Schema]]]
    @scala.annotation.targetName("floatBuilderFieldTypeBuilder")
    def floatBuilder: F[JFloatBuilder[JFloatDefault[Schema]]]
    @scala.annotation.targetName("floatTypeFieldTypeBuilder")
    def floatType: F[JFloatDefault[Schema]]
    @scala.annotation.targetName("intBuilderFieldTypeBuilder")
    def intBuilder: F[JIntBuilder[JIntDefault[Schema]]]
    @scala.annotation.targetName("intTypeFieldTypeBuilder")
    def intType: F[JIntDefault[Schema]]
    @scala.annotation.targetName("longBuilderFieldTypeBuilder")
    def longBuilder: F[JLongBuilder[JLongDefault[Schema]]]
    @scala.annotation.targetName("longTypeFieldTypeBuilder")
    def longType: F[JLongDefault[Schema]]
    @scala.annotation.targetName("mapFieldTypeBuilder")
    def map: F[JMapBuilder[JMapDefault[Schema]]]
    @scala.annotation.targetName("nullBuilderFieldTypeBuilder")
    def nullBuilder: F[JNullBuilder[JNullDefault[Schema]]]
    @scala.annotation.targetName("nullTypeFieldTypeBuilder")
    def nullType: F[JNullDefault[Schema]]
    @scala.annotation.targetName("recordFieldTypeBuilder")
    def record(name: String): F[JRecordBuilder[JRecordDefault[Schema]]]
    @scala.annotation.targetName("stringBuilderFieldTypeBuilder")
    def stringBuilder: F[JStringBuilder[JStringDefault[Schema]]]
    @scala.annotation.targetName("stringTypeFieldTypeBuilder")
    def stringType: F[JStringDefault[Schema]]
    @scala.annotation.targetName("unionOfFieldTypeBuilder")
    def unionOf: F[JUnionFieldTypeBuilder[Schema]]
  extension (fab: F[JFixedBuilder[Schema]])
    @scala.annotation.targetName("aliasesFixedBuilder")
    def aliases(aliases: String*): F[JFixedBuilder[Schema]]
    @scala.annotation.targetName("docFixedBuilder")
    def doc(doc: String): F[JFixedBuilder[Schema]]
    @scala.annotation.targetName("namespaceFixedBuilder")
    def namespace(namespace: String): F[JFixedBuilder[Schema]]
    @scala.annotation.targetName("propFixedBuilder")
    def prop(name: String, `val`: String): F[JFixedBuilder[Schema]]
    def size(size: Int): F[Schema]
  extension (fad: F[JFixedDefault[Schema]])
    def fixedDefault(defaultVal: Array[Byte]): F[JFieldAssembler[Schema]]
    def fixedDefault(defaultVal: ByteBuffer): F[JFieldAssembler[Schema]]
    def fixedDefault(defaultVal: String): F[JFieldAssembler[Schema]]
  extension (fgd: F[JGenericDefault[Schema]])
    @scala.annotation.targetName("noDefaultGenericDefault")
    def noDefault: F[JFieldAssembler[Schema]]
    def withDefault(defaultVal: Any): F[JFieldAssembler[Schema]]
  extension (fib: F[JIntBuilder[Schema]])
    def endInt: F[Schema]
    @scala.annotation.targetName("propIntBuilder")
    def prop(name: String, `val`: String): F[JIntBuilder[Schema]]
  extension (fid: F[JIntDefault[Schema]])
    def intDefault(defaultVal: Int): F[JFieldAssembler[Schema]]
  extension (flb: F[JLongBuilder[Schema]])
    def endLong: F[Schema]
    @scala.annotation.targetName("propLongBuilder")
    def prop(name: String, `val`: String): F[JLongBuilder[Schema]]
  extension (fld: F[JLongDefault[Schema]])
    def longDefault(defaultVal: Long): F[JFieldAssembler[Schema]]
  extension (fmb: F[JMapBuilder[Schema]])
    @scala.annotation.targetName("propMapBuilder")
    def prop(name: String, `val`: String): F[JMapBuilder[Schema]]
    def values: F[JTypeBuilder[Schema]]
    def values(valueSchema: Schema): F[Schema]
  extension (fmd: F[JMapDefault[Schema]])
    def mapDefault[V](defaultVal: Map[String, V]): F[JFieldAssembler[Schema]]
  extension (fnb: F[JNullBuilder[Schema]])
    def endNull: F[Schema]
    @scala.annotation.targetName("propNullBuilder")
    def prop(name: String, `val`: String): F[JNullBuilder[Schema]]
  extension (fnd: F[JNullDefault[Schema]])
    def nullDefault(): F[JFieldAssembler[Schema]]
  extension (frb: F[JRecordBuilder[Schema]])
    @scala.annotation.targetName("aliasesRecordBuilder")
    def aliases(aliases: String*): F[JRecordBuilder[Schema]]
    @scala.annotation.targetName("docRecordBuilder")
    def doc(doc: String): F[JRecordBuilder[Schema]]
    def fields: F[JFieldAssembler[Schema]]
    @scala.annotation.targetName("namespaceRecordBuilder")
    def namespace(namespace: String): F[JRecordBuilder[Schema]]
    @scala.annotation.targetName("propRecordBuilder")
    def prop(name: String, `val`: String): F[JRecordBuilder[Schema]]
  extension (frd: F[JRecordDefault[Schema]])
    def recordDefault(defaultVal: GenericRecord): F[JFieldAssembler[Schema]]
  extension (fsb: F[JStringBuilder[Schema]])
    def endString: F[Schema]
    @scala.annotation.targetName("propStringBuilder")
    def prop(name: String, `val`: String): F[JStringBuilder[Schema]]
  extension (fsd: F[JStringDefault[Schema]])
    def stringDefault(defaultVal: String): F[JFieldAssembler[Schema]]
  extension (ftb: F[JTypeBuilder[Schema]])
    @scala.annotation.targetName("arrayBuilderTypeBuilder")
    def array: F[JArrayBuilder[Schema]]
    @scala.annotation.targetName("booleanBuilderTypeBuilder")
    def booleanBuilder: F[JBooleanBuilder[Schema]]
    @scala.annotation.targetName("booleanTypeTypeBuilder")
    def booleanType: F[Schema]
    @scala.annotation.targetName("bytesBuilderTypeBuilder")
    def bytesBuilder: F[JBytesBuilder[Schema]]
    @scala.annotation.targetName("bytesTypeTypeBuilder")
    def bytesType: F[Schema]
    @scala.annotation.targetName("doubleBuilderTypeBuilder")
    def doubleBuilder: F[JDoubleBuilder[Schema]]
    @scala.annotation.targetName("doubleTypeTypeBuilder")
    def doubleType: F[Schema]
    @scala.annotation.targetName("enumerationTypeBuilder")
    def enumeration(name: String): F[JEnumBuilder[Schema]]
    @scala.annotation.targetName("fixedTypeBuilder")
    def fixed(name: String): F[JFixedBuilder[Schema]]
    @scala.annotation.targetName("floatBuilderTypeBuilder")
    def floatBuilder: F[JFloatBuilder[Schema]]
    @scala.annotation.targetName("floatTypeTypeBuilder")
    def floatType: F[Schema]
    @scala.annotation.targetName("intBuilderTypeBuilder")
    def intBuilder: F[JIntBuilder[Schema]]
    @scala.annotation.targetName("intTypeTypeBuilder")
    def intType: F[Schema]
    @scala.annotation.targetName("longBuilderTypeBuilder")
    def longBuilder: F[JLongBuilder[Schema]]
    @scala.annotation.targetName("longTypeTypeBuilder")
    def longType: F[Schema]
    @scala.annotation.targetName("mapTypeBuilder")
    def map: F[JMapBuilder[Schema]]
    @scala.annotation.targetName("nullBuilderTypeBuilder")
    def nullBuilder: F[JNullBuilder[Schema]]
    @scala.annotation.targetName("nullTypeTypeBuilder")
    def nullType: F[Schema]
    @scala.annotation.targetName("recordTypeBuilder")
    def record(name: String): F[JRecordBuilder[Schema]]
    @scala.annotation.targetName("stringBuilderTypeBuilder")
    def stringBuilder: F[JStringBuilder[Schema]]
    @scala.annotation.targetName("stringTypeTypeBuilder")
    def stringType: F[Schema]
    @scala.annotation.targetName("typeSchemaTypeBuilder")
    def `type`(schema: Schema): F[Schema]
    @scala.annotation.targetName("typeNameTypeBuilder")
    def `type`(name: String): F[Schema]
    @scala.annotation.targetName("typeFullNameTypeBuilder")
    def `type`(name: String, namespace: String): F[Schema]
    @scala.annotation.targetName("unionOfTypeBuilder")
    def unionOf: F[JBaseTypeBuilder[JUnionAccumulator[Schema]]]
  extension (fua: F[JUnionAccumulator[Schema]])
    def and: F[JBaseTypeBuilder[JUnionAccumulator[Schema]]]
    def endUnion: F[Schema]
  extension (fuftb: F[JUnionFieldTypeBuilder[Schema]])
    def array: F[JArrayBuilder[JUnionAccumulator[JArrayDefault[Schema]]]]
    def booleanBuilder: F[JBooleanBuilder[JUnionAccumulator[JBooleanDefault[Schema]]]]
    def booleanType: F[JUnionAccumulator[JBooleanDefault[Schema]]]
    def bytesBuilder: F[JBytesBuilder[JUnionAccumulator[JBytesDefault[Schema]]]]
    def bytesType: F[JUnionAccumulator[JBytesDefault[Schema]]]
    def doubleBuilder: F[JDoubleBuilder[JUnionAccumulator[JDoubleDefault[Schema]]]]
    def doubleType: F[JUnionAccumulator[JDoubleDefault[Schema]]]
    def enumeration(name: String): F[JEnumBuilder[JUnionAccumulator[JEnumDefault[Schema]]]]
    def fixed(name: String): F[JFixedBuilder[JUnionAccumulator[JFixedDefault[Schema]]]]
    def floatBuilder: F[JFloatBuilder[JUnionAccumulator[JFloatDefault[Schema]]]]
    def floatType: F[JUnionAccumulator[JFloatDefault[Schema]]]
    def intBuilder: F[JIntBuilder[JUnionAccumulator[JIntDefault[Schema]]]]
    def intType: F[JUnionAccumulator[JIntDefault[Schema]]]
    def longBuilder: F[JLongBuilder[JUnionAccumulator[JLongDefault[Schema]]]]
    def longType: F[JUnionAccumulator[JLongDefault[Schema]]]
    def map: F[JMapBuilder[JUnionAccumulator[JMapDefault[Schema]]]]
    def nullBuilder: F[JNullBuilder[JUnionAccumulator[JNullDefault[Schema]]]]
    def nullType: F[JUnionAccumulator[JNullDefault[Schema]]]
    def record(name: String): F[JRecordBuilder[JUnionAccumulator[JRecordDefault[Schema]]]]
    def stringBuilder: F[JStringBuilder[JUnionAccumulator[JStringDefault[Schema]]]]
    def stringType: F[JUnionAccumulator[JStringDefault[Schema]]]


object SchemaBuilder:

  given apply[F[_]: Sync](
    using
      AB: SchemaBuilder.ArrayBuilder[F, Schema],
      AD: SchemaBuilder.ArrayDefault[F, Schema],
      BAF: SchemaBuilder.BaseFieldTypeBuilder[F, Schema],
      BAT: SchemaBuilder.BaseTypeBuilder[F, Schema],
      BOB: SchemaBuilder.BooleanBuilder[F, Schema],
      BOD: SchemaBuilder.BooleanDefault[F, Schema],
      BYB: SchemaBuilder.BytesBuilder[F, Schema],
      BYD: SchemaBuilder.BytesDefault[F, Schema],
      DB: SchemaBuilder.DoubleBuilder[F, Schema],
      DD: SchemaBuilder.DoubleDefault[F, Schema],
      EB: SchemaBuilder.EnumBuilder[F, Schema],
      ED: SchemaBuilder.EnumDefault[F, Schema],
      FA: SchemaBuilder.FieldAssembler[F, Schema],
      FB: SchemaBuilder.FieldBuilder[F, Schema],
      FD: SchemaBuilder.FieldDefault[F, Schema],
      FXB: SchemaBuilder.FixedBuilder[F, Schema],
      FXD: SchemaBuilder.FixedDefault[F, Schema],
      FTB: SchemaBuilder.FieldTypeBuilder[F, Schema],
      GD: SchemaBuilder.GenericDefault[F, Schema],
      IB: SchemaBuilder.IntBuilder[F, Schema],
      ID: SchemaBuilder.IntDefault[F, Schema],
      LB: SchemaBuilder.LongBuilder[F, Schema],
      LD: SchemaBuilder.LongDefault[F, Schema],
      MB: SchemaBuilder.MapBuilder[F, Schema],
      MD: SchemaBuilder.MapDefault[F, Schema],
      NMB: SchemaBuilder.NamedBuilder[F, Schema],
      NSB: SchemaBuilder.NamespacedBuilder[F, Schema],
      NB: SchemaBuilder.NullBuilder[F, Schema],
      ND: SchemaBuilder.NullDefault[F, Schema],
      PB: SchemaBuilder.PropBuilder[F, Schema],
      RB: SchemaBuilder.RecordBuilder[F, Schema],
      RD: SchemaBuilder.RecordDefault[F, Schema],
      SB: SchemaBuilder.StringBuilder[F, Schema],
      SD: SchemaBuilder.StringDefault[F, Schema],
      TB: SchemaBuilder.TypeBuilder[F, Schema],
      UA: SchemaBuilder.UnionAccumulator[F, Schema],
      UFTB: SchemaBuilder.UnionFieldTypeBuilder[F, Schema],
  ): SchemaBuilder[F] =
    new SchemaBuilder[F]:

      def array: F[JArrayBuilder[Schema]] =
        Sync[F].delay(org.apache.avro.SchemaBuilder.array())
      def builder: F[JTypeBuilder[Schema]] =
        Sync[F].delay(org.apache.avro.SchemaBuilder.builder())
      def builder(namespace: String): F[JTypeBuilder[Schema]] =
        Sync[F].delay(org.apache.avro.SchemaBuilder.builder(namespace))
      def enumeration(name: String): F[JEnumBuilder[Schema]] =
        Sync[F].delay(org.apache.avro.SchemaBuilder.enumeration(name))
      def fixed(name: String): F[JFixedBuilder[Schema]] =
        Sync[F].delay(org.apache.avro.SchemaBuilder.fixed(name))
      def map: F[JMapBuilder[Schema]] =
        Sync[F].delay(org.apache.avro.SchemaBuilder.map())
      def nullable: F[JBaseTypeBuilder[Schema]] =
        Sync[F].delay(org.apache.avro.SchemaBuilder.nullable())
      def record(name: String): F[JRecordBuilder[Schema]] =
        Sync[F].delay(org.apache.avro.SchemaBuilder.record(name))
      def unionOf: F[JBaseTypeBuilder[JUnionAccumulator[Schema]]] =
        Sync[F].delay(org.apache.avro.SchemaBuilder.unionOf())

      extension (fab: F[JArrayBuilder[Schema]])
        def items: F[JTypeBuilder[Schema]] =
          fab.flatMap(ab => AB.items(ab))
        def items(itemsSchema: Schema): F[Schema] =
          fab.flatMap(ab => AB.items(ab)(itemsSchema))
        @scala.annotation.targetName("propArrayBuilder")
        def prop(name: String, `val`: String): F[JArrayBuilder[Schema]] =
          fab.flatMap(ab => PB.prop(ab)(name, `val`))

      extension (fad: F[JArrayDefault[Schema]])
        def arrayDefault[V](defaultVal: List[V]): F[JFieldAssembler[Schema]] =
          fad.flatMap(ad => AD.arrayDefault(ad)(defaultVal))

      extension (fbftb: F[JBaseFieldTypeBuilder[Schema]])
        @scala.annotation.targetName("arrayBuilderBaseFieldTypeBuilder")
        def array: F[JArrayBuilder[JArrayDefault[Schema]]] =
          fbftb.flatMap(ftb => BAF.array(ftb))
        @scala.annotation.targetName("booleanBuilderBaseFieldTypeBuilder")
        def booleanBuilder: F[JBooleanBuilder[JBooleanDefault[Schema]]] =
          fbftb.flatMap(ftb => BAF.booleanBuilder(ftb))
        @scala.annotation.targetName("booleanTypeBaseFieldTypeBuilder")
        def booleanType: F[JBooleanDefault[Schema]] =
          fbftb.flatMap(ftb => BAF.booleanType(ftb))
        @scala.annotation.targetName("bytesBuilderBaseFieldTypeBuilder")
        def bytesBuilder: F[JBytesBuilder[JBytesDefault[Schema]]] =
          fbftb.flatMap(ftb => BAF.bytesBuilder(ftb))
        @scala.annotation.targetName("bytesTypeBaseFieldTypeBuilder")
        def bytesType: F[JBytesDefault[Schema]] =
          fbftb.flatMap(ftb => BAF.bytesType(ftb))
        @scala.annotation.targetName("doubleBuilderBaseFieldTypeBuilder")
        def doubleBuilder: F[JDoubleBuilder[JDoubleDefault[Schema]]] =
          fbftb.flatMap(ftb => BAF.doubleBuilder(ftb))
        @scala.annotation.targetName("doubleTypeBaseFieldTypeBuilder")
        def doubleType: F[JDoubleDefault[Schema]] =
          fbftb.flatMap(ftb => BAF.doubleType(ftb))
        @scala.annotation.targetName("enumerationBaseFieldTypeBuilder")
        def enumeration(name: String): F[JEnumBuilder[JEnumDefault[Schema]]] =
          fbftb.flatMap(ftb => BAF.enumeration(ftb)(name))
        @scala.annotation.targetName("fixedBaseFieldTypeBuilder")
        def fixed(name: String): F[JFixedBuilder[JFixedDefault[Schema]]] =
          fbftb.flatMap(ftb => BAF.fixed(ftb)(name))
        @scala.annotation.targetName("floatBuilderBaseFieldTypeBuilder")
        def floatBuilder: F[JFloatBuilder[JFloatDefault[Schema]]] =
          fbftb.flatMap(ftb => BAF.floatBuilder(ftb))
        @scala.annotation.targetName("floatTypeBaseFieldTypeBuilder")
        def floatType: F[JFloatDefault[Schema]] =
          fbftb.flatMap(ftb => BAF.floatType(ftb))
        @scala.annotation.targetName("intBuilderBaseFieldTypeBuilder")
        def intBuilder: F[JIntBuilder[JIntDefault[Schema]]] =
          fbftb.flatMap(ftb => BAF.intBuilder(ftb))
        @scala.annotation.targetName("intTypeBaseFieldTypeBuilder")
        def intType: F[JIntDefault[Schema]] =
          fbftb.flatMap(ftb => BAF.intType(ftb))
        @scala.annotation.targetName("longBuilderBaseFieldTypeBuilder")
        def longBuilder: F[JLongBuilder[JLongDefault[Schema]]] =
          fbftb.flatMap(ftb => BAF.longBuilder(ftb))
        @scala.annotation.targetName("longTypeBaseFieldTypeBuilder")
        def longType: F[JLongDefault[Schema]] =
          fbftb.flatMap(ftb => BAF.longType(ftb))
        @scala.annotation.targetName("mapBaseFieldTypeBuilder")
        def map: F[JMapBuilder[JMapDefault[Schema]]] =
          fbftb.flatMap(ftb => BAF.map(ftb))
        @scala.annotation.targetName("nullBuilderBaseFieldTypeBuilder")
        def nullBuilder: F[JNullBuilder[JNullDefault[Schema]]] =
          fbftb.flatMap(ftb => BAF.nullBuilder(ftb))
        @scala.annotation.targetName("nullTypeBaseFieldTypeBuilder")
        def nullType: F[JNullDefault[Schema]] =
          fbftb.flatMap(ftb => BAF.nullType(ftb))
        @scala.annotation.targetName("recordBaseFieldTypeBuilder")
        def record(name: String): F[JRecordBuilder[JRecordDefault[Schema]]] =
          fbftb.flatMap(ftb => BAF.record(ftb)(name))
        @scala.annotation.targetName("stringBuilderBaseFieldTypeBuilder")
        def stringBuilder: F[JStringBuilder[JStringDefault[Schema]]] =
          fbftb.flatMap(ftb => BAF.stringBuilder(ftb))
        @scala.annotation.targetName("stringTypeBaseFieldTypeBuilder")
        def stringType: F[JStringDefault[Schema]] =
          fbftb.flatMap(ftb => BAF.stringType(ftb))

      extension (fbtb: F[JBaseTypeBuilder[Schema]])
        @scala.annotation.targetName("arrayBuilderBaseTypeBuilder")
        def array: F[JArrayBuilder[Schema]] =
          fbtb.flatMap(btb => BAT.array(btb))
        @scala.annotation.targetName("booleanBuilderBaseTypeBuilder")
        def booleanBuilder: F[JBooleanBuilder[Schema]] =
          fbtb.flatMap(btb => BAT.booleanBuilder(btb))
        @scala.annotation.targetName("booleanTypeBaseTypeBuilder")
        def booleanType: F[Schema] =
          fbtb.flatMap(btb => BAT.booleanType(btb))
        @scala.annotation.targetName("bytesBuilderBaseTypeBuilder")
        def bytesBuilder: F[JBytesBuilder[Schema]] =
          fbtb.flatMap(btb => BAT.bytesBuilder(btb))
        @scala.annotation.targetName("bytesTypeBaseTypeBuilder")
        def bytesType: F[Schema] =
          fbtb.flatMap(btb => BAT.bytesType(btb))
        @scala.annotation.targetName("doubleBuilderBaseTypeBuilder")
        def doubleBuilder: F[JDoubleBuilder[Schema]] =
          fbtb.flatMap(btb => BAT.doubleBuilder(btb))
        @scala.annotation.targetName("doubleTypeBaseTypeBuilder")
        def doubleType: F[Schema] =
          fbtb.flatMap(btb => BAT.doubleType(btb))
        @scala.annotation.targetName("enumerationBaseTypeBuilder")
        def enumeration(name: String): F[JEnumBuilder[Schema]] =
          fbtb.flatMap(btb => BAT.enumeration(btb)(name))
        @scala.annotation.targetName("fixedBaseTypeBuilder")
        def fixed(name: String): F[JFixedBuilder[Schema]] =
          fbtb.flatMap(btb => BAT.fixed(btb)(name))
        @scala.annotation.targetName("floatBuilderBaseTypeBuilder")
        def floatBuilder: F[JFloatBuilder[Schema]] =
          fbtb.flatMap(btb => BAT.floatBuilder(btb))
        @scala.annotation.targetName("floatTypeBaseTypeBuilder")
        def floatType: F[Schema] =
          fbtb.flatMap(btb => BAT.floatType(btb))
        @scala.annotation.targetName("intBuilderBaseTypeBuilder")
        def intBuilder: F[JIntBuilder[Schema]] =
          fbtb.flatMap(btb => BAT.intBuilder(btb))
        @scala.annotation.targetName("intTypeBaseTypeBuilder")
        def intType: F[Schema] =
          fbtb.flatMap(btb => BAT.intType(btb))
        @scala.annotation.targetName("longBuilderBaseTypeBuilder")
        def longBuilder: F[JLongBuilder[Schema]] =
          fbtb.flatMap(btb => BAT.longBuilder(btb))
        @scala.annotation.targetName("longTypeBaseTypeBuilder")
        def longType: F[Schema] =
          fbtb.flatMap(btb => BAT.longType(btb))
        @scala.annotation.targetName("mapBaseTypeBuilder")
        def map: F[JMapBuilder[Schema]] =
          fbtb.flatMap(btb => BAT.map(btb))
        @scala.annotation.targetName("nullBuilderBaseTypeBuilder")
        def nullBuilder: F[JNullBuilder[Schema]] =
          fbtb.flatMap(btb => BAT.nullBuilder(btb))
        @scala.annotation.targetName("nullTypeBaseTypeBuilder")
        def nullType: F[Schema] =
          fbtb.flatMap(btb => BAT.nullType(btb))
        @scala.annotation.targetName("recordBaseTypeBuilder")
        def record(name: String): F[JRecordBuilder[Schema]] =
          fbtb.flatMap(btb => BAT.record(btb)(name))
        @scala.annotation.targetName("stringBuilderBaseTypeBuilder")
        def stringBuilder: F[JStringBuilder[Schema]] =
          fbtb.flatMap(btb => BAT.stringBuilder(btb))
        @scala.annotation.targetName("stringTypeBaseTypeBuilder")
        def stringType: F[Schema] =
          fbtb.flatMap(btb => BAT.stringType(btb))
        @scala.annotation.targetName("typeSchemaBaseTypeBuilder")
        def `type`(schema: Schema): F[Schema] =
          fbtb.flatMap(btb => BAT.`type`(btb)(schema))
        @scala.annotation.targetName("typeNameBaseTypeBuilder")
        def `type`(name: String): F[Schema] =
          fbtb.flatMap(btb => BAT.`type`(btb)(name))
        @scala.annotation.targetName("typeFullNameBaseTypeBuilder")
        def `type`(name: String, namespace: String): F[Schema] =
          fbtb.flatMap(btb => BAT.`type`(btb)(name, namespace))

      extension (fbb: F[JBooleanBuilder[Schema]])
        def endBoolean: F[Schema] =
          fbb.flatMap(bb => BOB.endBoolean(bb))
        @scala.annotation.targetName("propBooleanBuilder")
        def prop(name: String, `val`: String): F[JBooleanBuilder[Schema]] =
          fbb.flatMap(ab => PB.prop(ab)(name, `val`))

      extension (fbd: F[JBooleanDefault[Schema]])
        def booleanDefault(defaultVal: Boolean): F[JFieldAssembler[Schema]] =
          fbd.flatMap(bd => BOD.booleanDefault(bd)(defaultVal))

      extension (fabb: F[JBytesBuilder[Schema]])
        def endBytes: F[Schema] =
          fabb.flatMap(abb => BYB.endBytes(abb))
        @scala.annotation.targetName("propBytesBuilder")
        def prop(name: String, `val`: String): F[JBytesBuilder[Schema]] =
          fabb.flatMap(abb => PB.prop(abb)(name, `val`))

      extension (fbd: F[JBytesDefault[Schema]])
        def bytesDefault(defaultVal: Array[Byte]): F[JFieldAssembler[Schema]] =
          fbd.flatMap(bd => BYD.bytesDefault(bd)(defaultVal))
        def bytesDefault(defaultVal: ByteBuffer): F[JFieldAssembler[Schema]] =
          fbd.flatMap(bd => BYD.bytesDefault(bd)(defaultVal))
        def bytesDefault(defaultVal: String): F[JFieldAssembler[Schema]] =
          fbd.flatMap(bd => BYD.bytesDefault(bd)(defaultVal))

      extension (fdb: F[JDoubleBuilder[Schema]])
        def endDouble: F[Schema] =
          fdb.flatMap(db => DB.endDouble(db))
        @scala.annotation.targetName("propDoubleBuilder")
        def prop(name: String, `val`: String): F[JDoubleBuilder[Schema]] =
          fdb.flatMap(db => PB.prop(db)(name, `val`))

      extension (fdd: F[JDoubleDefault[Schema]])
        def doubleDefault(defaultVal: Double): F[JFieldAssembler[Schema]] =
          fdd.flatMap(dd => DD.doubleDefault(dd)(defaultVal))

      extension (feb: F[JEnumBuilder[Schema]])
        @scala.annotation.targetName("aliasesEnumBuilder")
        def aliases(aliases: String*): F[JEnumBuilder[Schema]] =
          feb.flatMap(eb => NMB.aliases(eb)(aliases*))
        @scala.annotation.targetName("docEnumBuilder")
        def doc(doc: String): F[JEnumBuilder[Schema]] =
          feb.flatMap(eb => NMB.doc(eb)(doc))
        @scala.annotation.targetName("namespaceEnumBuilder")
        def namespace(namespace: String): F[JEnumBuilder[Schema]] =
          feb.flatMap(eb => NSB.namespace(eb)(namespace))
        @scala.annotation.targetName("propEnumBuilder")
        def prop(name: String, `val`: String): F[JEnumBuilder[Schema]] =
          feb.flatMap(eb => PB.prop(eb)(name, `val`))
        def symbols(symbols: String*): F[Schema] =
          feb.flatMap(eb => EB.symbols(eb)(symbols*))

      extension (fed: F[JEnumDefault[Schema]])
        def enumDefault(defaultVal: String): F[JFieldAssembler[Schema]] =
          fed.flatMap(ed => ED.enumDefault(ed)(defaultVal))

      extension (ffa: F[JFieldAssembler[Schema]])
        def endRecord: F[Schema] =
          ffa.flatMap(fa => FA.endRecord(fa))
        def name(fieldName: String): F[JFieldBuilder[Schema]] =
          ffa.flatMap(fa => FA.name(fa)(fieldName))
    
      extension (ffb: F[JFieldBuilder[Schema]])
        @scala.annotation.targetName("aliasesFieldBuilder")
        def aliases(aliases: String*): F[JFieldBuilder[Schema]] =
          ffb.flatMap(fb => NMB.aliases(fb)(aliases*))
        @scala.annotation.targetName("docFieldBuilder")
        def doc(doc: String): F[JFieldBuilder[Schema]] =
          ffb.flatMap(fb => NMB.doc(fb)(doc))
        def orderAscending: F[JFieldBuilder[Schema]] =
          ffb.flatMap(fb => FB.orderAscending(fb))
        def orderDescending: F[JFieldBuilder[Schema]] =
          ffb.flatMap(fb => FB.orderAscending(fb))
        def orderIgnore: F[JFieldBuilder[Schema]] =
          ffb.flatMap(fb => FB.orderAscending(fb))
        @scala.annotation.targetName("propFieldBuilder")
        def prop(name: String, `val`: String): F[JFieldBuilder[Schema]] =
          ffb.flatMap(fb => PB.prop(fb)(name, `val`))
        @scala.annotation.targetName("typeFieldBuilder")
        def `type`: F[JFieldTypeBuilder[Schema]] =
          ffb.flatMap(fb => FB.`type`(fb))

      extension [U <: JFieldDefault[Schema, U]] (ffd: F[JFieldDefault[Schema, U]])
        def noDefault: F[JFieldAssembler[Schema]] =
          ffd.flatMap(fd => FD.noDefault(fd))

      extension (fftb: F[JFieldTypeBuilder[Schema]])
        @scala.annotation.targetName("arrayBuilderFieldTypeBuilder")
        def array: F[JArrayBuilder[JArrayDefault[Schema]]] =
          fftb.flatMap(ftb => FTB.array(ftb))
        @scala.annotation.targetName("booleanBuilderFieldTypeBuilder")
        def booleanBuilder: F[JBooleanBuilder[JBooleanDefault[Schema]]] =
          fftb.flatMap(ftb => FTB.booleanBuilder(ftb))
        @scala.annotation.targetName("booleanTypeFieldTypeBuilder")
        def booleanType: F[JBooleanDefault[Schema]] =
          fftb.flatMap(ftb => FTB.booleanType(ftb))
        @scala.annotation.targetName("bytesBuilderFieldTypeBuilder")
        def bytesBuilder: F[JBytesBuilder[JBytesDefault[Schema]]] =
          fftb.flatMap(ftb => FTB.bytesBuilder(ftb))
        @scala.annotation.targetName("bytesTypeFieldTypeBuilder")
        def bytesType: F[JBytesDefault[Schema]] =
          fftb.flatMap(ftb => FTB.bytesType(ftb))
        @scala.annotation.targetName("doubleBuilderFieldTypeBuilder")
        def doubleBuilder: F[JDoubleBuilder[JDoubleDefault[Schema]]] =
          fftb.flatMap(ftb => FTB.doubleBuilder(ftb))
        @scala.annotation.targetName("doubleTypeFieldTypeBuilder")
        def doubleType: F[JDoubleDefault[Schema]] =
          fftb.flatMap(ftb => FTB.doubleType(ftb))
        @scala.annotation.targetName("enumerationFieldTypeBuilder")
        def enumeration(name: String): F[JEnumBuilder[JEnumDefault[Schema]]] =
          fftb.flatMap(ftb => FTB.enumeration(ftb)(name))
        @scala.annotation.targetName("fixedFieldTypeBuilder")
        def fixed(name: String): F[JFixedBuilder[JFixedDefault[Schema]]] =
          fftb.flatMap(ftb => FTB.fixed(ftb)(name))
        @scala.annotation.targetName("floatBuilderFieldTypeBuilder")
        def floatBuilder: F[JFloatBuilder[JFloatDefault[Schema]]] =
          fftb.flatMap(ftb => FTB.floatBuilder(ftb))
        @scala.annotation.targetName("floatTypeFieldTypeBuilder")
        def floatType: F[JFloatDefault[Schema]] =
          fftb.flatMap(ftb => FTB.floatType(ftb))
        @scala.annotation.targetName("intBuilderFieldTypeBuilder")
        def intBuilder: F[JIntBuilder[JIntDefault[Schema]]] =
          fftb.flatMap(ftb => FTB.intBuilder(ftb))
        @scala.annotation.targetName("intTypeFieldTypeBuilder")
        def intType: F[JIntDefault[Schema]] =
          fftb.flatMap(ftb => FTB.intType(ftb))
        @scala.annotation.targetName("longBuilderFieldTypeBuilder")
        def longBuilder: F[JLongBuilder[JLongDefault[Schema]]] =
          fftb.flatMap(ftb => FTB.longBuilder(ftb))
        @scala.annotation.targetName("longTypeFieldTypeBuilder")
        def longType: F[JLongDefault[Schema]] =
          fftb.flatMap(ftb => FTB.longType(ftb))
        @scala.annotation.targetName("mapFieldTypeBuilder")
        def map: F[JMapBuilder[JMapDefault[Schema]]] =
          fftb.flatMap(ftb => FTB.map(ftb))
        @scala.annotation.targetName("nullBuilderFieldTypeBuilder")
        def nullBuilder: F[JNullBuilder[JNullDefault[Schema]]] =
          fftb.flatMap(ftb => FTB.nullBuilder(ftb))
        @scala.annotation.targetName("nullTypeFieldTypeBuilder")
        def nullType: F[JNullDefault[Schema]] =
          fftb.flatMap(ftb => FTB.nullType(ftb))
        @scala.annotation.targetName("recordFieldTypeBuilder")
        def record(name: String): F[JRecordBuilder[JRecordDefault[Schema]]] =
          fftb.flatMap(ftb => FTB.record(ftb)(name))
        @scala.annotation.targetName("stringBuilderFieldTypeBuilder")
        def stringBuilder: F[JStringBuilder[JStringDefault[Schema]]] =
          fftb.flatMap(ftb => FTB.stringBuilder(ftb))
        @scala.annotation.targetName("stringTypeFieldTypeBuilder")
        def stringType: F[JStringDefault[Schema]] =
          fftb.flatMap(ftb => FTB.stringType(ftb))

        @scala.annotation.targetName("unionOfFieldTypeBuilder")
        def unionOf: F[JUnionFieldTypeBuilder[Schema]] =
          fftb.flatMap(ftb => FTB.unionOf(ftb))

      extension (ffxb: F[JFixedBuilder[Schema]])
        @scala.annotation.targetName("aliasesFixedBuilder")
        def aliases(aliases: String*): F[JFixedBuilder[Schema]] =
          ffxb.flatMap(fxb => NMB.aliases(fxb)(aliases*))
        @scala.annotation.targetName("docFixedBuilder")
        def doc(doc: String): F[JFixedBuilder[Schema]] =
          ffxb.flatMap(fxb => NMB.doc(fxb)(doc))
        @scala.annotation.targetName("namespaceFixedBuilder")
        def namespace(namespace: String): F[JFixedBuilder[Schema]] =
          ffxb.flatMap(fxb => NSB.namespace(fxb)(namespace))
        @scala.annotation.targetName("propFixedBuilder")
        def prop(name: String, `val`: String): F[JFixedBuilder[Schema]] =
          ffxb.flatMap(fxb => PB.prop(fxb)(name, `val`))
        def size(size: Int): F[Schema] =
          ffxb.flatMap(fxb => FXB.size(fxb)(size))

      extension (ffxd: F[JFixedDefault[Schema]])
        def fixedDefault(defaultVal: Array[Byte]): F[JFieldAssembler[Schema]] =
          ffxd.flatMap(fxd => FXD.fixedDefault(fxd)(defaultVal))
        def fixedDefault(defaultVal: ByteBuffer): F[JFieldAssembler[Schema]] =
          ffxd.flatMap(fxd => FXD.fixedDefault(fxd)(defaultVal))
        def fixedDefault(defaultVal: String): F[JFieldAssembler[Schema]] =
          ffxd.flatMap(fxd => FXD.fixedDefault(fxd)(defaultVal))

      extension (fgd: F[JGenericDefault[Schema]])
        @scala.annotation.targetName("noDefaultGenericDefault")
        def noDefault: F[JFieldAssembler[Schema]] =
          fgd.flatMap(gd => GD.noDefault(gd))
        def withDefault(defaultVal: Any): F[JFieldAssembler[Schema]] =
          fgd.flatMap(gd => GD.withDefault(gd)(defaultVal))

      extension (fib: F[JIntBuilder[Schema]])
        def endInt: F[Schema] =
          fib.flatMap(ib => IB.endInt(ib))
        @scala.annotation.targetName("propIntBuilder")
        def prop(name: String, `val`: String): F[JIntBuilder[Schema]] =
          fib.flatMap(ib => PB.prop(ib)(name, `val`))

      extension (fid: F[JIntDefault[Schema]])
        def intDefault(defaultVal: Int): F[JFieldAssembler[Schema]] =
          fid.flatMap(id => ID.intDefault(id)(defaultVal))

      extension (flb: F[JLongBuilder[Schema]])
        def endLong: F[Schema] =
          flb.flatMap(lb => LB.endLong(lb))
        @scala.annotation.targetName("propLongBuilder")
        def prop(name: String, `val`: String): F[JLongBuilder[Schema]] =
          flb.flatMap(lb => PB.prop(lb)(name, `val`))

      extension (fld: F[JLongDefault[Schema]])
        def longDefault(defaultVal: Long): F[JFieldAssembler[Schema]] =
          fld.flatMap(ld => LD.longDefault(ld)(defaultVal))

      extension (fmb: F[JMapBuilder[Schema]])
        def values: F[JTypeBuilder[Schema]] =
          fmb.flatMap(mb => MB.values(mb))
        def values(valueSchema: Schema): F[Schema] =
          fmb.flatMap(mb => MB.values(mb)(valueSchema))
        @scala.annotation.targetName("propMapBuilder")
        def prop(name: String, `val`: String): F[JMapBuilder[Schema]] =
          fmb.flatMap(mb => PB.prop(mb)(name, `val`))

      extension (fmd: F[JMapDefault[Schema]])
        def mapDefault[V](defaultVal: Map[String, V]): F[JFieldAssembler[Schema]] =
          fmd.flatMap(md => MD.mapDefault(md)(defaultVal))

      extension (fnb: F[JNullBuilder[Schema]])
        def endNull: F[Schema] =
          fnb.flatMap(nb => NB.endNull(nb))
        @scala.annotation.targetName("propNullBuilder")
        def prop(name: String, `val`: String): F[JNullBuilder[Schema]] =
          fnb.flatMap(nb => PB.prop(nb)(name, `val`))

      extension (fnd: F[JNullDefault[Schema]])
        def nullDefault(): F[JFieldAssembler[Schema]] =
          fnd.flatMap(nd => ND.nullDefault(nd))

      extension (frb: F[JRecordBuilder[Schema]])
        @scala.annotation.targetName("aliasesRecordBuilder")
        def aliases(aliases: String*): F[JRecordBuilder[Schema]] =
          frb.flatMap(rb => NMB.aliases(rb)(aliases*))
        @scala.annotation.targetName("docRecordBuilder")
        def doc(doc: String): F[JRecordBuilder[Schema]] =
          frb.flatMap(rb => NMB.doc(rb)(doc))
        def fields: F[JFieldAssembler[Schema]] =
          frb.flatMap(rb => RB.fields(rb))
        @scala.annotation.targetName("namespaceRecordBuilder")
        def namespace(namespace: String): F[JRecordBuilder[Schema]] =
          frb.flatMap(nrb => NSB.namespace(nrb)(namespace))
        @scala.annotation.targetName("propRecordBuilder")
        def prop(name: String, `val`: String): F[JRecordBuilder[Schema]] =
          frb.flatMap(rb => PB.prop(rb)(name, `val`))

      extension (frd: F[JRecordDefault[Schema]])
        def recordDefault(defaultVal: GenericRecord): F[JFieldAssembler[Schema]] =
          frd.flatMap(rd => RD.recordDefault(rd)(defaultVal))

      extension (fsb: F[JStringBuilder[Schema]])
        def endString: F[Schema] =
          fsb.flatMap(sb => SB.endString(sb))
        @scala.annotation.targetName("propStringBuilder")
        def prop(name: String, `val`: String): F[JStringBuilder[Schema]] =
          fsb.flatMap(sb => PB.prop(sb)(name, `val`))

      extension (fsd: F[JStringDefault[Schema]])
        def stringDefault(defaultVal: String): F[JFieldAssembler[Schema]] =
          fsd.flatMap(sd => SD.stringDefault(sd)(defaultVal))

      extension (ftb: F[JTypeBuilder[Schema]])
        @scala.annotation.targetName("arrayBuilderTypeBuilder")
        def array: F[JArrayBuilder[Schema]] =
          ftb.flatMap(tb => BAT.array(tb))
        @scala.annotation.targetName("booleanBuilderTypeBuilder")
        def booleanBuilder: F[JBooleanBuilder[Schema]] =
          ftb.flatMap(tb => BAT.booleanBuilder(tb))
        @scala.annotation.targetName("booleanTypeTypeBuilder")
        def booleanType: F[Schema] =
          ftb.flatMap(tb => BAT.booleanType(tb))
        @scala.annotation.targetName("bytesBuilderTypeBuilder")
        def bytesBuilder: F[JBytesBuilder[Schema]] =
          ftb.flatMap(tb => BAT.bytesBuilder(tb))
        @scala.annotation.targetName("bytesTypeTypeBuilder")
        def bytesType: F[Schema] =
          ftb.flatMap(tb => BAT.bytesType(tb))
        @scala.annotation.targetName("doubleBuilderTypeBuilder")
        def doubleBuilder: F[JDoubleBuilder[Schema]] =
          ftb.flatMap(tb => BAT.doubleBuilder(tb))
        @scala.annotation.targetName("doubleTypeTypeBuilder")
        def doubleType: F[Schema] =
          ftb.flatMap(tb => BAT.doubleType(tb))
        @scala.annotation.targetName("enumerationTypeBuilder")
        def enumeration(name: String): F[JEnumBuilder[Schema]] =
          ftb.flatMap(tb => BAT.enumeration(tb)(name))
        @scala.annotation.targetName("fixedTypeBuilder")
        def fixed(name: String): F[JFixedBuilder[Schema]] =
          ftb.flatMap(tb => BAT.fixed(tb)(name))
        @scala.annotation.targetName("floatBuilderTypeBuilder")
        def floatBuilder: F[JFloatBuilder[Schema]] =
          ftb.flatMap(tb => BAT.floatBuilder(tb))
        @scala.annotation.targetName("floatTypeTypeBuilder")
        def floatType: F[Schema] =
          ftb.flatMap(tb => BAT.floatType(tb))
        @scala.annotation.targetName("intBuilderTypeBuilder")
        def intBuilder: F[JIntBuilder[Schema]] =
          ftb.flatMap(tb => BAT.intBuilder(tb))
        @scala.annotation.targetName("intTypeTypeBuilder")
        def intType: F[Schema] =
          ftb.flatMap(tb => BAT.intType(tb))
        @scala.annotation.targetName("longBuilderTypeBuilder")
        def longBuilder: F[JLongBuilder[Schema]] =
          ftb.flatMap(tb => BAT.longBuilder(tb))
        @scala.annotation.targetName("longTypeTypeBuilder")
        def longType: F[Schema] =
          ftb.flatMap(tb => BAT.longType(tb))
        @scala.annotation.targetName("mapTypeBuilder")
        def map: F[JMapBuilder[Schema]] =
          ftb.flatMap(tb => BAT.map(tb))
        @scala.annotation.targetName("nullBuilderTypeBuilder")
        def nullBuilder: F[JNullBuilder[Schema]] =
          ftb.flatMap(tb => BAT.nullBuilder(tb))
        @scala.annotation.targetName("nullTypeTypeBuilder")
        def nullType: F[Schema] =
          ftb.flatMap(tb => BAT.nullType(tb))
        @scala.annotation.targetName("recordTypeBuilder")
        def record(name: String): F[JRecordBuilder[Schema]] =
          ftb.flatMap(tb => BAT.record(tb)(name))
        @scala.annotation.targetName("stringBuilderTypeBuilder")
        def stringBuilder: F[JStringBuilder[Schema]] =
          ftb.flatMap(tb => BAT.stringBuilder(tb))
        @scala.annotation.targetName("stringTypeTypeBuilder")
        def stringType: F[Schema] =
          ftb.flatMap(tb => BAT.stringType(tb))
        @scala.annotation.targetName("typeSchemaTypeBuilder")
        def `type`(schema: Schema): F[Schema] =
          ftb.flatMap(tb => BAT.`type`(tb)(schema))
        @scala.annotation.targetName("typeNameTypeBuilder")
        def `type`(name: String): F[Schema] =
          ftb.flatMap(tb => BAT.`type`(tb)(name))
        @scala.annotation.targetName("typeFullNameTypeBuilder")
        def `type`(name: String, namespace: String): F[Schema] =
          ftb.flatMap(tb => BAT.`type`(tb)(name, namespace))
        @scala.annotation.targetName("unionOfTypeBuilder")
        def unionOf: F[JBaseTypeBuilder[JUnionAccumulator[Schema]]] =
          ftb.flatMap(tb => TB.unionOf(tb))

      extension (fua: F[JUnionAccumulator[Schema]])
        def and: F[JBaseTypeBuilder[JUnionAccumulator[Schema]]] =
          fua.flatMap(ua => UA.and(ua))
        def endUnion: F[Schema] =
          fua.flatMap(ua => UA.endUnion(ua))

      extension (fuftb: F[JUnionFieldTypeBuilder[Schema]])
        def array: F[JArrayBuilder[JUnionAccumulator[JArrayDefault[Schema]]]] =
          fuftb.flatMap(utfb => UFTB.array(utfb))
        def booleanBuilder: F[JBooleanBuilder[JUnionAccumulator[JBooleanDefault[Schema]]]] =
          fuftb.flatMap(utfb => UFTB.booleanBuilder(utfb))
        def booleanType: F[JUnionAccumulator[JBooleanDefault[Schema]]] =
          fuftb.flatMap(utfb => UFTB.booleanType(utfb))
        def bytesBuilder: F[JBytesBuilder[JUnionAccumulator[JBytesDefault[Schema]]]] =
          fuftb.flatMap(utfb => UFTB.bytesBuilder(utfb))
        def bytesType: F[JUnionAccumulator[JBytesDefault[Schema]]] =
          fuftb.flatMap(utfb => UFTB.bytesType(utfb))
        def doubleBuilder: F[JDoubleBuilder[JUnionAccumulator[JDoubleDefault[Schema]]]] =
          fuftb.flatMap(utfb => UFTB.doubleBuilder(utfb))
        def doubleType: F[JUnionAccumulator[JDoubleDefault[Schema]]] =
          fuftb.flatMap(utfb => UFTB.doubleType(utfb))
        def enumeration(name: String): F[JEnumBuilder[JUnionAccumulator[JEnumDefault[Schema]]]] =
          fuftb.flatMap(utfb => UFTB.enumeration(utfb)(name))
        def fixed(name: String): F[JFixedBuilder[JUnionAccumulator[JFixedDefault[Schema]]]] =
          fuftb.flatMap(utfb => UFTB.fixed(utfb)(name))
        def floatBuilder: F[JFloatBuilder[JUnionAccumulator[JFloatDefault[Schema]]]] =
          fuftb.flatMap(utfb => UFTB.floatBuilder(utfb))
        def floatType: F[JUnionAccumulator[JFloatDefault[Schema]]] =
          fuftb.flatMap(utfb => UFTB.floatType(utfb))
        def intBuilder: F[JIntBuilder[JUnionAccumulator[JIntDefault[Schema]]]] =
          fuftb.flatMap(utfb => UFTB.intBuilder(utfb))
        def intType: F[JUnionAccumulator[JIntDefault[Schema]]] =
          fuftb.flatMap(utfb => UFTB.intType(utfb))
        def longBuilder: F[JLongBuilder[JUnionAccumulator[JLongDefault[Schema]]]] =
          fuftb.flatMap(utfb => UFTB.longBuilder(utfb))
        def longType: F[JUnionAccumulator[JLongDefault[Schema]]] =
          fuftb.flatMap(utfb => UFTB.longType(utfb))
        def map: F[JMapBuilder[JUnionAccumulator[JMapDefault[Schema]]]] =
          fuftb.flatMap(utfb => UFTB.map(utfb))
        def nullBuilder: F[JNullBuilder[JUnionAccumulator[JNullDefault[Schema]]]] =
          fuftb.flatMap(utfb => UFTB.nullBuilder(utfb))
        def nullType: F[JUnionAccumulator[JNullDefault[Schema]]] =
          fuftb.flatMap(utfb => UFTB.nullType(utfb))
        def record(name: String): F[JRecordBuilder[JUnionAccumulator[JRecordDefault[Schema]]]] =
          fuftb.flatMap(utfb => UFTB.record(utfb)(name))
        def stringBuilder: F[JStringBuilder[JUnionAccumulator[JStringDefault[Schema]]]] =
          fuftb.flatMap(utfb => UFTB.stringBuilder(utfb))
        def stringType: F[JUnionAccumulator[JStringDefault[Schema]]] =
          fuftb.flatMap(utfb => UFTB.stringType(utfb))

  trait ArrayBuilder[F[_], T]:
    def items(fab: JArrayBuilder[T]): F[JTypeBuilder[T]]
    def items(fab: JArrayBuilder[T])(itemsSchema: Schema): F[T]
  object ArrayBuilder:
    given [F[_]: Sync, T]: ArrayBuilder[F, T] =
      new ArrayBuilder[F, T]:
        def items(ab: JArrayBuilder[T]): F[JTypeBuilder[T]] =
          Sync[F].delay(ab.items())
        def items(ab: JArrayBuilder[T])(itemsSchema: Schema): F[T] =
          Sync[F].delay(ab.items(itemsSchema))

  trait ArrayDefault[F[_], T]:
    def arrayDefault[V](ad: JArrayDefault[T])(defaultVal: List[V]): F[JFieldAssembler[T]]
  object ArrayDefault:
    given [F[_]: Sync, T]: ArrayDefault[F, T] =
      new ArrayDefault[F, T]:
        def arrayDefault[V](ad: JArrayDefault[T])(defaultVal: List[V]): F[JFieldAssembler[T]] =
          Sync[F].delay(ad.arrayDefault(defaultVal.asJava))

  trait BaseFieldTypeBuilder[F[_], T]:
    def array(bftb: JBaseFieldTypeBuilder[T]): F[JArrayBuilder[JArrayDefault[T]]]
    def booleanBuilder(bftb: JBaseFieldTypeBuilder[T]): F[JBooleanBuilder[JBooleanDefault[T]]]
    def booleanType(bftb: JBaseFieldTypeBuilder[T]): F[JBooleanDefault[T]]
    def bytesBuilder(bftb: JBaseFieldTypeBuilder[T]): F[JBytesBuilder[JBytesDefault[T]]]
    def bytesType(bftb: JBaseFieldTypeBuilder[T]): F[JBytesDefault[T]]
    def doubleBuilder(bftb: JBaseFieldTypeBuilder[T]): F[JDoubleBuilder[JDoubleDefault[T]]]
    def doubleType(bftb: JBaseFieldTypeBuilder[T]): F[JDoubleDefault[T]]
    def enumeration(bftb: JBaseFieldTypeBuilder[T])(name: String): F[JEnumBuilder[JEnumDefault[T]]]
    def fixed(bftb: JBaseFieldTypeBuilder[T])(name: String): F[JFixedBuilder[JFixedDefault[T]]]
    def floatBuilder(bftb: JBaseFieldTypeBuilder[T]): F[JFloatBuilder[JFloatDefault[T]]]
    def floatType(bftb: JBaseFieldTypeBuilder[T]): F[JFloatDefault[T]]
    def intBuilder(bftb: JBaseFieldTypeBuilder[T]): F[JIntBuilder[JIntDefault[T]]]
    def intType(bftb: JBaseFieldTypeBuilder[T]): F[JIntDefault[T]]
    def longBuilder(bftb: JBaseFieldTypeBuilder[T]): F[JLongBuilder[JLongDefault[T]]]
    def longType(bftb: JBaseFieldTypeBuilder[T]): F[JLongDefault[T]]
    def map(bftb: JBaseFieldTypeBuilder[T]): F[JMapBuilder[JMapDefault[T]]]
    def nullBuilder(bftb: JBaseFieldTypeBuilder[T]): F[JNullBuilder[JNullDefault[T]]]
    def nullType(bftb: JBaseFieldTypeBuilder[T]): F[JNullDefault[T]]
    def record(bftb: JBaseFieldTypeBuilder[T])(name: String): F[JRecordBuilder[JRecordDefault[T]]]
    def stringBuilder(bftb: JBaseFieldTypeBuilder[T]): F[JStringBuilder[JStringDefault[T]]]
    def stringType(bftb: JBaseFieldTypeBuilder[T]): F[JStringDefault[T]]

  object BaseFieldTypeBuilder:
    given [F[_]: Sync, T]: BaseFieldTypeBuilder[F, T] =
      new BaseFieldTypeBuilder[F, T]:
        def array(bftb: JBaseFieldTypeBuilder[T]): F[JArrayBuilder[JArrayDefault[T]]] =
          Sync[F].delay(bftb.array())
        def booleanBuilder(bftb: JBaseFieldTypeBuilder[T]): F[JBooleanBuilder[JBooleanDefault[T]]] =
          Sync[F].delay(bftb.booleanBuilder())
        def booleanType(bftb: JBaseFieldTypeBuilder[T]): F[JBooleanDefault[T]] =
          Sync[F].delay(bftb.booleanType())
        def bytesBuilder(bftb: JBaseFieldTypeBuilder[T]): F[JBytesBuilder[JBytesDefault[T]]] =
          Sync[F].delay(bftb.bytesBuilder())
        def bytesType(bftb: JBaseFieldTypeBuilder[T]): F[JBytesDefault[T]] =
          Sync[F].delay(bftb.bytesType())
        def doubleBuilder(bftb: JBaseFieldTypeBuilder[T]): F[JDoubleBuilder[JDoubleDefault[T]]] =
          Sync[F].delay(bftb.doubleBuilder())
        def doubleType(bftb: JBaseFieldTypeBuilder[T]): F[JDoubleDefault[T]] =
          Sync[F].delay(bftb.doubleType())
        def enumeration(bftb: JBaseFieldTypeBuilder[T])(name: String): F[JEnumBuilder[JEnumDefault[T]]] =
          Sync[F].delay(bftb.enumeration(name))
        def fixed(bftb: JBaseFieldTypeBuilder[T])(name: String): F[JFixedBuilder[JFixedDefault[T]]] =
          Sync[F].delay(bftb.fixed(name))
        def floatBuilder(bftb: JBaseFieldTypeBuilder[T]): F[JFloatBuilder[JFloatDefault[T]]] =
          Sync[F].delay(bftb.floatBuilder())
        def floatType(bftb: JBaseFieldTypeBuilder[T]): F[JFloatDefault[T]] =
          Sync[F].delay(bftb.floatType())
        def intBuilder(bftb: JBaseFieldTypeBuilder[T]): F[JIntBuilder[JIntDefault[T]]] =
          Sync[F].delay(bftb.intBuilder())
        def intType(bftb: JBaseFieldTypeBuilder[T]): F[JIntDefault[T]] =
          Sync[F].delay(bftb.intType())
        def longBuilder(bftb: JBaseFieldTypeBuilder[T]): F[JLongBuilder[JLongDefault[T]]] =
          Sync[F].delay(bftb.longBuilder())
        def longType(bftb: JBaseFieldTypeBuilder[T]): F[JLongDefault[T]] =
          Sync[F].delay(bftb.longType())
        def map(bftb: JBaseFieldTypeBuilder[T]): F[JMapBuilder[JMapDefault[T]]] =
          Sync[F].delay(bftb.map())
        def nullBuilder(bftb: JBaseFieldTypeBuilder[T]): F[JNullBuilder[JNullDefault[T]]] =
          Sync[F].delay(bftb.nullBuilder())
        def nullType(bftb: JBaseFieldTypeBuilder[T]): F[JNullDefault[T]] =
          Sync[F].delay(bftb.nullType())
        def record(bftb: JBaseFieldTypeBuilder[T])(name: String): F[JRecordBuilder[JRecordDefault[T]]] =
          Sync[F].delay(bftb.record(name))
        def stringBuilder(bftb: JBaseFieldTypeBuilder[T]): F[JStringBuilder[JStringDefault[T]]] =
          Sync[F].delay(bftb.stringBuilder())
        def stringType(bftb: JBaseFieldTypeBuilder[T]): F[JStringDefault[T]] =
          Sync[F].delay(bftb.stringType())

  trait BaseTypeBuilder[F[_], T]:
    def array(btb: JBaseTypeBuilder[T]): F[JArrayBuilder[T]]
    def booleanBuilder(btb: JBaseTypeBuilder[T]): F[JBooleanBuilder[T]]
    def booleanType(btb: JBaseTypeBuilder[T]): F[T]
    def bytesBuilder(btb: JBaseTypeBuilder[T]): F[JBytesBuilder[T]]
    def bytesType(btb: JBaseTypeBuilder[T]): F[T]
    def doubleBuilder(btb: JBaseTypeBuilder[T]): F[JDoubleBuilder[T]]
    def doubleType(btb: JBaseTypeBuilder[T]): F[T]
    def enumeration(btb: JBaseTypeBuilder[T])(name: String): F[JEnumBuilder[T]]
    def fixed(btb: JBaseTypeBuilder[T])(name: String): F[JFixedBuilder[T]]
    def floatBuilder(btb: JBaseTypeBuilder[T]): F[JFloatBuilder[T]]
    def floatType(btb: JBaseTypeBuilder[T]): F[T]
    def intBuilder(btb: JBaseTypeBuilder[T]): F[JIntBuilder[T]]
    def intType(btb: JBaseTypeBuilder[T]): F[T]
    def longBuilder(btb: JBaseTypeBuilder[T]): F[JLongBuilder[T]]
    def longType(btb: JBaseTypeBuilder[T]): F[T]
    def map(btb: JBaseTypeBuilder[T]): F[JMapBuilder[T]]
    def nullBuilder(btb: JBaseTypeBuilder[T]): F[JNullBuilder[T]]
    def nullType(btb: JBaseTypeBuilder[T]): F[T]
    def record(btb: JBaseTypeBuilder[T])(name: String): F[JRecordBuilder[T]]
    def stringBuilder(btb: JBaseTypeBuilder[T]): F[JStringBuilder[T]]
    def stringType(btb: JBaseTypeBuilder[T]): F[T]
    def `type`(btb: JBaseTypeBuilder[T])(schema: Schema): F[T]
    def `type`(btb: JBaseTypeBuilder[T])(name: String): F[T]
    def `type`(btb: JBaseTypeBuilder[T])(name: String, namespace: String): F[T]

  object BaseTypeBuilder:
    given [F[_]: Sync, T]: BaseTypeBuilder[F, T] =
      new BaseTypeBuilder[F, T]:
        def array(btb: JBaseTypeBuilder[T]): F[JArrayBuilder[T]] =
          Sync[F].delay(btb.array())
        def booleanBuilder(btb: JBaseTypeBuilder[T]): F[JBooleanBuilder[T]] =
          Sync[F].delay(btb.booleanBuilder())
        def booleanType(btb: JBaseTypeBuilder[T]): F[T] =
          Sync[F].delay(btb.booleanType())
        def bytesBuilder(btb: JBaseTypeBuilder[T]): F[JBytesBuilder[T]] =
          Sync[F].delay(btb.bytesBuilder())
        def bytesType(btb: JBaseTypeBuilder[T]): F[T] =
          Sync[F].delay(btb.bytesType())
        def doubleBuilder(btb: JBaseTypeBuilder[T]): F[JDoubleBuilder[T]] =
          Sync[F].delay(btb.doubleBuilder())
        def doubleType(btb: JBaseTypeBuilder[T]): F[T] =
          Sync[F].delay(btb.doubleType())
        def enumeration(btb: JBaseTypeBuilder[T])(name: String): F[JEnumBuilder[T]] =
          Sync[F].delay(btb.enumeration(name))
        def fixed(btb: JBaseTypeBuilder[T])(name: String): F[JFixedBuilder[T]] =
          Sync[F].delay(btb.fixed(name))
        def floatBuilder(btb: JBaseTypeBuilder[T]): F[JFloatBuilder[T]] =
          Sync[F].delay(btb.floatBuilder())
        def floatType(btb: JBaseTypeBuilder[T]): F[T] =
          Sync[F].delay(btb.floatType())
        def intBuilder(btb: JBaseTypeBuilder[T]): F[JIntBuilder[T]] =
          Sync[F].delay(btb.intBuilder())
        def intType(btb: JBaseTypeBuilder[T]): F[T] =
          Sync[F].delay(btb.intType())
        def longBuilder(btb: JBaseTypeBuilder[T]): F[JLongBuilder[T]] =
          Sync[F].delay(btb.longBuilder())
        def longType(btb: JBaseTypeBuilder[T]): F[T] =
          Sync[F].delay(btb.longType())
        def map(btb: JBaseTypeBuilder[T]): F[JMapBuilder[T]] =
          Sync[F].delay(btb.map())
        def nullBuilder(btb: JBaseTypeBuilder[T]): F[JNullBuilder[T]] =
          Sync[F].delay(btb.nullBuilder())
        def nullType(btb: JBaseTypeBuilder[T]): F[T] =
          Sync[F].delay(btb.nullType())
        def record(btb: JBaseTypeBuilder[T])(name: String): F[JRecordBuilder[T]] =
          Sync[F].delay(btb.record(name))
        def stringBuilder(btb: JBaseTypeBuilder[T]): F[JStringBuilder[T]] =
          Sync[F].delay(btb.stringBuilder())
        def stringType(btb: JBaseTypeBuilder[T]): F[T] =
          Sync[F].delay(btb.stringType())
        def `type`(btb: JBaseTypeBuilder[T])(schema: Schema): F[T] =
          Sync[F].delay(btb.`type`(schema))
        def `type`(btb: JBaseTypeBuilder[T])(name: String): F[T] =
          Sync[F].delay(btb.`type`(name))
        def `type`(btb: JBaseTypeBuilder[T])(name: String, namespace: String): F[T] =
          Sync[F].delay(btb.`type`(name, namespace))

  trait BooleanBuilder[F[_], T]:
    def endBoolean(bb: JBooleanBuilder[T]): F[T]    
  object BooleanBuilder:
    given [F[_]: Sync, T]: BooleanBuilder[F, T] =
      new BooleanBuilder[F, T]:
        def endBoolean(bb: JBooleanBuilder[T]): F[T] =
          Sync[F].delay(bb.endBoolean())

  trait BooleanDefault[F[_], T]:
    def booleanDefault(bd: JBooleanDefault[T])(defaultVal: Boolean): F[JFieldAssembler[T]]
  object BooleanDefault:
    given [F[_]: Sync, T]: BooleanDefault[F, T] =
      new BooleanDefault[F, T]:
        def booleanDefault(bd: JBooleanDefault[T])(defaultVal: Boolean): F[JFieldAssembler[T]] =
          Sync[F].delay(bd.booleanDefault(defaultVal))

  trait BytesBuilder[F[_], T]:
    def endBytes(bb: JBytesBuilder[T]): F[T]    
  object BytesBuilder:
    given [F[_]: Sync, T]: BytesBuilder[F, T] =
      new BytesBuilder[F, T]:
        def endBytes(bb: JBytesBuilder[T]): F[T] =
          Sync[F].delay(bb.endBytes())

  trait BytesDefault[F[_], T]:
    def bytesDefault(bd: JBytesDefault[T])(defaultVal: Array[Byte]): F[JFieldAssembler[T]]
    def bytesDefault(bd: JBytesDefault[T])(defaultVal: ByteBuffer): F[JFieldAssembler[T]]
    def bytesDefault(bd: JBytesDefault[T])(defaultVal: String): F[JFieldAssembler[T]]
  object BytesDefault:
    given [F[_]: Sync, T]: BytesDefault[F, T] =
      new BytesDefault[F, T]:
        def bytesDefault(bd: JBytesDefault[T])(defaultVal: Array[Byte]): F[JFieldAssembler[T]] =
          Sync[F].delay(bd.bytesDefault(defaultVal))
        def bytesDefault(bd: JBytesDefault[T])(defaultVal: ByteBuffer): F[JFieldAssembler[T]] =
          Sync[F].delay(bd.bytesDefault(defaultVal))
        def bytesDefault(bd: JBytesDefault[T])(defaultVal: String): F[JFieldAssembler[T]] =
          Sync[F].delay(bd.bytesDefault(defaultVal))

  trait DoubleBuilder[F[_], T]:
    def endDouble(bb: JDoubleBuilder[T]): F[T]    
  object DoubleBuilder:
    given [F[_]: Sync, T]: DoubleBuilder[F, T] =
      new DoubleBuilder[F, T]:
        def endDouble(bb: JDoubleBuilder[T]): F[T] =
          Sync[F].delay(bb.endDouble())

  trait DoubleDefault[F[_], T]:
    def doubleDefault(bd: JDoubleDefault[T])(defaultVal: Double): F[JFieldAssembler[T]]
  object DoubleDefault:
    given [F[_]: Sync, T]: DoubleDefault[F, T] =
      new DoubleDefault[F, T]:
        def doubleDefault(bd: JDoubleDefault[T])(defaultVal: Double): F[JFieldAssembler[T]] =
          Sync[F].delay(bd.doubleDefault(defaultVal))

  trait EnumBuilder[F[_], T]:
    def symbols(eb: JEnumBuilder[T])(symbols: String*): F[T]    
  object EnumBuilder:
    given [F[_]: Sync, T](using NSB: NamespacedBuilder[F, T]): EnumBuilder[F, T] =
      new EnumBuilder[F, T]:
        def symbols(eb: JEnumBuilder[T])(symbols: String*): F[T] =
          Sync[F].delay(eb.symbols(symbols*))

  trait EnumDefault[F[_], T]:
    def enumDefault(ed: JEnumDefault[T])(defaultVal: String): F[JFieldAssembler[T]]
  object EnumDefault:
    given [F[_]: Sync, T]: EnumDefault[F, T] =
      new EnumDefault[F, T]:
        def enumDefault(ed: JEnumDefault[T])(defaultVal: String): F[JFieldAssembler[T]] =
          Sync[F].delay(ed.enumDefault(defaultVal))

  trait FieldAssembler[F[_], T]:
    def endRecord(fa: JFieldAssembler[T]): F[T]
    def name(fa: JFieldAssembler[T])(fieldName: String): F[JFieldBuilder[T]]
  object FieldAssembler:
    given [F[_]: Sync, T]: FieldAssembler[F, T] =
      new FieldAssembler[F, T]:
        def endRecord(fa: JFieldAssembler[T]): F[T] =
          Sync[F].delay(fa.endRecord())
        def name(fa: JFieldAssembler[T])(fieldName: String): F[JFieldBuilder[T]] =
          Sync[F].delay(fa.name(fieldName))

  trait FieldBuilder[F[_], T]:
    def orderAscending(fb: JFieldBuilder[T]): F[JFieldBuilder[T]]    
    def orderDescending(fb: JFieldBuilder[T]): F[JFieldBuilder[T]]    
    def orderIgnore(fb: JFieldBuilder[T]): F[JFieldBuilder[T]]    
    def `type`(fb: JFieldBuilder[T]): F[JFieldTypeBuilder[T]]    
  object FieldBuilder:
    given [F[_]: Sync, T]: FieldBuilder[F, T] =
      new FieldBuilder[F, T]:
        def orderAscending(fb: JFieldBuilder[T]): F[JFieldBuilder[T]] =
          Sync[F].delay(fb.orderAscending())
        def orderDescending(fb: JFieldBuilder[T]): F[JFieldBuilder[T]] =
          Sync[F].delay(fb.orderDescending())
        def orderIgnore(fb: JFieldBuilder[T]): F[JFieldBuilder[T]] =
          Sync[F].delay(fb.orderIgnore())
        def `type`(fb: JFieldBuilder[T]): F[JFieldTypeBuilder[T]] =
          Sync[F].delay(fb.`type`())

  trait FieldDefault[F[_], T]:
    def noDefault[U <: JFieldDefault[T, U]](fd: JFieldDefault[T, U]): F[JFieldAssembler[T]]
  object FieldDefault:
    given [F[_]: Sync, T]: FieldDefault[F, T] =
      new FieldDefault[F, T]:
        def noDefault[U <: JFieldDefault[T, U]](fd: JFieldDefault[T, U]): F[JFieldAssembler[T]] =
          Sync[F].delay(fd.noDefault())

  trait FieldTypeBuilder[F[_], T]:
    def array(ftb: JFieldTypeBuilder[T]): F[JArrayBuilder[JArrayDefault[T]]]
    def booleanBuilder(ftb: JFieldTypeBuilder[T]): F[JBooleanBuilder[JBooleanDefault[T]]]
    def booleanType(ftb: JFieldTypeBuilder[T]): F[JBooleanDefault[T]]
    def bytesBuilder(ftb: JFieldTypeBuilder[T]): F[JBytesBuilder[JBytesDefault[T]]]
    def bytesType(ftb: JFieldTypeBuilder[T]): F[JBytesDefault[T]]
    def doubleBuilder(ftb: JFieldTypeBuilder[T]): F[JDoubleBuilder[JDoubleDefault[T]]]
    def doubleType(ftb: JFieldTypeBuilder[T]): F[JDoubleDefault[T]]
    def enumeration(ftb: JFieldTypeBuilder[T])(name: String): F[JEnumBuilder[JEnumDefault[T]]]
    def fixed(ftb: JFieldTypeBuilder[T])(name: String): F[JFixedBuilder[JFixedDefault[T]]]
    def floatBuilder(ftb: JFieldTypeBuilder[T]): F[JFloatBuilder[JFloatDefault[T]]]
    def floatType(ftb: JFieldTypeBuilder[T]): F[JFloatDefault[T]]
    def intBuilder(ftb: JFieldTypeBuilder[T]): F[JIntBuilder[JIntDefault[T]]]
    def intType(ftb: JFieldTypeBuilder[T]): F[JIntDefault[T]]
    def longBuilder(ftb: JFieldTypeBuilder[T]): F[JLongBuilder[JLongDefault[T]]]
    def longType(ftb: JFieldTypeBuilder[T]): F[JLongDefault[T]]
    def map(ftb: JFieldTypeBuilder[T]): F[JMapBuilder[JMapDefault[T]]]
    def nullBuilder(ftb: JFieldTypeBuilder[T]): F[JNullBuilder[JNullDefault[T]]]
    def nullType(ftb: JFieldTypeBuilder[T]): F[JNullDefault[T]]
    def record(ftb: JFieldTypeBuilder[T])(name: String): F[JRecordBuilder[JRecordDefault[T]]]
    def stringBuilder(ftb: JFieldTypeBuilder[T]): F[JStringBuilder[JStringDefault[T]]]
    def stringType(ftb: JFieldTypeBuilder[T]): F[JStringDefault[T]]
    def unionOf(ftb: JFieldTypeBuilder[T]): F[JUnionFieldTypeBuilder[T]]
  object FieldTypeBuilder:
    given [F[_]: Sync, T]: FieldTypeBuilder[F, T] =
      new FieldTypeBuilder[F, T]:
        def unionOf(ftb: JFieldTypeBuilder[T]): F[JUnionFieldTypeBuilder[T]] =
          Sync[F].delay(ftb.unionOf())
        def array(ftb: JFieldTypeBuilder[T]): F[JArrayBuilder[JArrayDefault[T]]] =
          Sync[F].delay(ftb.array())
        def booleanBuilder(ftb: JFieldTypeBuilder[T]): F[JBooleanBuilder[JBooleanDefault[T]]] =
          Sync[F].delay(ftb.booleanBuilder())
        def booleanType(ftb: JFieldTypeBuilder[T]): F[JBooleanDefault[T]] =
          Sync[F].delay(ftb.booleanType())
        def bytesBuilder(ftb: JFieldTypeBuilder[T]): F[JBytesBuilder[JBytesDefault[T]]] =
          Sync[F].delay(ftb.bytesBuilder())
        def bytesType(ftb: JFieldTypeBuilder[T]): F[JBytesDefault[T]] =
          Sync[F].delay(ftb.bytesType())
        def doubleBuilder(ftb: JFieldTypeBuilder[T]): F[JDoubleBuilder[JDoubleDefault[T]]] =
          Sync[F].delay(ftb.doubleBuilder())
        def doubleType(ftb: JFieldTypeBuilder[T]): F[JDoubleDefault[T]] =
          Sync[F].delay(ftb.doubleType())
        def enumeration(ftb: JFieldTypeBuilder[T])(name: String): F[JEnumBuilder[JEnumDefault[T]]] =
          Sync[F].delay(ftb.enumeration(name))
        def fixed(ftb: JFieldTypeBuilder[T])(name: String): F[JFixedBuilder[JFixedDefault[T]]] =
          Sync[F].delay(ftb.fixed(name))
        def floatBuilder(ftb: JFieldTypeBuilder[T]): F[JFloatBuilder[JFloatDefault[T]]] =
          Sync[F].delay(ftb.floatBuilder())
        def floatType(ftb: JFieldTypeBuilder[T]): F[JFloatDefault[T]] =
          Sync[F].delay(ftb.floatType())
        def intBuilder(ftb: JFieldTypeBuilder[T]): F[JIntBuilder[JIntDefault[T]]] =
          Sync[F].delay(ftb.intBuilder())
        def intType(ftb: JFieldTypeBuilder[T]): F[JIntDefault[T]] =
          Sync[F].delay(ftb.intType())
        def longBuilder(ftb: JFieldTypeBuilder[T]): F[JLongBuilder[JLongDefault[T]]] =
          Sync[F].delay(ftb.longBuilder())
        def longType(ftb: JFieldTypeBuilder[T]): F[JLongDefault[T]] =
          Sync[F].delay(ftb.longType())
        def map(ftb: JFieldTypeBuilder[T]): F[JMapBuilder[JMapDefault[T]]] =
          Sync[F].delay(ftb.map())
        def nullBuilder(ftb: JFieldTypeBuilder[T]): F[JNullBuilder[JNullDefault[T]]] =
          Sync[F].delay(ftb.nullBuilder())
        def nullType(ftb: JFieldTypeBuilder[T]): F[JNullDefault[T]] =
          Sync[F].delay(ftb.nullType())
        def record(ftb: JFieldTypeBuilder[T])(name: String): F[JRecordBuilder[JRecordDefault[T]]] =
          Sync[F].delay(ftb.record(name))
        def stringBuilder(ftb: JFieldTypeBuilder[T]): F[JStringBuilder[JStringDefault[T]]] =
          Sync[F].delay(ftb.stringBuilder())
        def stringType(ftb: JFieldTypeBuilder[T]): F[JStringDefault[T]] =
          Sync[F].delay(ftb.stringType())

  trait FixedBuilder[F[_], T]:
    def size(fb: JFixedBuilder[T])(size: Int): F[T]
  object FixedBuilder:
    given [F[_]: Sync, T](using NSB: NamespacedBuilder[F, T]): FixedBuilder[F, T] =
      new FixedBuilder[F, T]:
        def size(fb: JFixedBuilder[T])(size: Int): F[T] =
          Sync[F].delay(fb.size(size))

  trait FixedDefault[F[_], T]:
    def fixedDefault(gd: JFixedDefault[T])(defaultVal: Array[Byte]): F[JFieldAssembler[T]]
    def fixedDefault(gd: JFixedDefault[T])(defaultVal: ByteBuffer): F[JFieldAssembler[T]]
    def fixedDefault(gd: JFixedDefault[T])(defaultVal: String): F[JFieldAssembler[T]]
  object FixedDefault:
    given [F[_]: Sync, T]: FixedDefault[F, T] =
      new FixedDefault[F, T]:
        def fixedDefault(gd: JFixedDefault[T])(defaultVal: Array[Byte]): F[JFieldAssembler[T]] =
          Sync[F].delay(gd.fixedDefault(defaultVal))
        def fixedDefault(gd: JFixedDefault[T])(defaultVal: ByteBuffer): F[JFieldAssembler[T]] =
          Sync[F].delay(gd.fixedDefault(defaultVal))
        def fixedDefault(gd: JFixedDefault[T])(defaultVal: String): F[JFieldAssembler[T]] =
          Sync[F].delay(gd.fixedDefault(defaultVal))

  trait GenericDefault[F[_], T]:
    def noDefault(gd: JGenericDefault[T]): F[JFieldAssembler[T]]
    def withDefault(gd: JGenericDefault[T])(defaultVal: Any): F[JFieldAssembler[T]]
  object GenericDefault:
    given [F[_]: Sync, T]: GenericDefault[F, T] =
      new GenericDefault[F, T]:
        def noDefault(gd: JGenericDefault[T]): F[JFieldAssembler[T]] =
          Sync[F].delay(gd.noDefault())
        def withDefault(gd: JGenericDefault[T])(defaultVal: Any): F[JFieldAssembler[T]] =
          Sync[F].delay(gd.withDefault(defaultVal))

  trait IntBuilder[F[_], T]:
    def endInt(ib: JIntBuilder[T]): F[T]    
  object IntBuilder:
    given [F[_]: Sync, T]: IntBuilder[F, T] =
      new IntBuilder[F, T]:
        def endInt(ib: JIntBuilder[T]): F[T] =
          Sync[F].delay(ib.endInt())

  trait IntDefault[F[_], T]:
    def intDefault(id: JIntDefault[T])(defaultVal: Int): F[JFieldAssembler[T]]
  object IntDefault:
    given [F[_]: Sync, T]: IntDefault[F, T] =
      new IntDefault[F, T]:
        def intDefault(id: JIntDefault[T])(defaultVal: Int): F[JFieldAssembler[T]] =
          Sync[F].delay(id.intDefault(defaultVal))

  trait LongBuilder[F[_], T]:
    def endLong(lb: JLongBuilder[T]): F[T]    
  object LongBuilder:
    given [F[_]: Sync, T]: LongBuilder[F, T] =
      new LongBuilder[F, T]:
        def endLong(lb: JLongBuilder[T]): F[T] =
          Sync[F].delay(lb.endLong())

  trait LongDefault[F[_], T]:
    def longDefault(ld: JLongDefault[T])(defaultVal: Long): F[JFieldAssembler[T]]
  object LongDefault:
    given [F[_]: Sync, T]: LongDefault[F, T] =
      new LongDefault[F, T]:
        def longDefault(ld: JLongDefault[T])(defaultVal: Long): F[JFieldAssembler[T]] =
          Sync[F].delay(ld.longDefault(defaultVal))

  trait MapBuilder[F[_], T]:
    def values(mb: JMapBuilder[T]): F[JTypeBuilder[T]]
    def values(mb: JMapBuilder[T])(valueSchema: Schema): F[T]
  object MapBuilder:
    given [F[_]: Sync, T]: MapBuilder[F, T] =
      new MapBuilder[F, T]:
        def values(mb: JMapBuilder[T]): F[JTypeBuilder[T]] =
          Sync[F].delay(mb.values())
        def values(mb: JMapBuilder[T])(valueSchema: Schema): F[T] =
          Sync[F].delay(mb.values(valueSchema))

  trait MapDefault[F[_], T]:
    def mapDefault[V](md: JMapDefault[T])(defaultVal: Map[String, V]): F[JFieldAssembler[T]]
  object MapDefault:
    given [F[_]: Sync, T]: MapDefault[F, T] =
      new MapDefault[F, T]:
        def mapDefault[V](md: JMapDefault[T])(defaultVal: Map[String, V]): F[JFieldAssembler[T]] =
          Sync[F].delay(md.mapDefault(defaultVal.asJava))

  trait NamedBuilder[F[_], T]:
    def aliases[U <: JNamedBuilder[U]](nb: U)(aliases: String*): F[U]
    def doc[U <: JNamedBuilder[U]](nb: U)(doc: String): F[U]
  object NamedBuilder:
    given [F[_]: Sync, T]: NamedBuilder[F, T] =
      new NamedBuilder[F, T]:
        def aliases[U <: JNamedBuilder[U]](nb: U)(aliases: String*): F[U] =
          Sync[F].delay(nb.aliases(aliases*))
        def doc[U <: JNamedBuilder[U]](nb: U)(doc: String): F[U] =
          Sync[F].delay(nb.doc(doc))


  trait NamespacedBuilder[F[_], T]:
    def namespace[T, U <: JNamespacedBuilder[T, U]](nb: JNamespacedBuilder[T, U])(namespace: String): F[U]
  object NamespacedBuilder:
    given [F[_]: Sync, T]: NamespacedBuilder[F, T] =
      new NamespacedBuilder[F, T]:
        def namespace[T, U <: JNamespacedBuilder[T, U]](nb: JNamespacedBuilder[T, U])(namespace: String): F[U] =
          Sync[F].delay(nb.namespace(namespace))

  trait NullBuilder[F[_], T]:
    def endNull(nb: JNullBuilder[T]): F[T]    
  object NullBuilder:
    given [F[_]: Sync, T]: NullBuilder[F, T] =
      new NullBuilder[F, T]:
        def endNull(nb: JNullBuilder[T]): F[T] =
          Sync[F].delay(nb.endNull())

  trait NullDefault[F[_], T]:
    def nullDefault(nd: JNullDefault[T]): F[JFieldAssembler[T]]
  object NullDefault:
    given [F[_]: Sync, T]: NullDefault[F, T] =
      new NullDefault[F, T]:
        def nullDefault(nd: JNullDefault[T]): F[JFieldAssembler[T]] =
          Sync[F].delay(nd.nullDefault())

  trait PropBuilder[F[_], T]:
    def prop[U <: JPropBuilder[U]](pb: U)(name: String, `val`: String): F[U]    
  object PropBuilder:
    given [F[_]: Sync, T]: PropBuilder[F, T] =
      new PropBuilder[F, T]:
        def prop[U <: JPropBuilder[U]](pb: U)(name: String, `val`: String): F[U] =
          Sync[F].delay(pb.prop(name, `val`))

  trait RecordBuilder[F[_], T]:
    def fields(rb: JRecordBuilder[Schema]): F[JFieldAssembler[Schema]]
  object RecordBuilder:
    given [F[_]: Sync, T](using NSB: NamespacedBuilder[F, T]): RecordBuilder[F, T] =
      new RecordBuilder[F, T]:
        def fields(rb: JRecordBuilder[Schema]): F[JFieldAssembler[Schema]] =
          Sync[F].delay(rb.fields())

  trait RecordDefault[F[_], T]:
    def recordDefault(rd: JRecordDefault[T])(defaultValue: GenericRecord): F[JFieldAssembler[T]]
  object RecordDefault:
    given [F[_]: Sync, T]: RecordDefault[F, T] =
      new RecordDefault[F, T]:
        def recordDefault(rd: JRecordDefault[T])(defaultValue: GenericRecord): F[JFieldAssembler[T]] =
          Sync[F].delay(rd.recordDefault(defaultValue))

  trait StringBuilder[F[_], T]:
    def endString(sb: JStringBuilder[T]): F[T]    
  object StringBuilder:
    given [F[_]: Sync, T]: StringBuilder[F, T] =
      new StringBuilder[F, T]:
        def endString(sb: JStringBuilder[T]): F[T] =
          Sync[F].delay(sb.endString())

  trait StringDefault[F[_], T]:
    def stringDefault(sd: JStringDefault[T])(defaultVal: String): F[JFieldAssembler[T]]
  object StringDefault:
    given [F[_]: Sync, T]: StringDefault[F, T] =
      new StringDefault[F, T]:
        def stringDefault(sd: JStringDefault[T])(defaultVal: String): F[JFieldAssembler[T]] =
          Sync[F].delay(sd.stringDefault(defaultVal))
          
  trait TypeBuilder[F[_], T]:
    def array(tb: JTypeBuilder[T]): F[JArrayBuilder[T]]
    def booleanBuilder(tb: JTypeBuilder[T]): F[JBooleanBuilder[T]]
    def booleanType(tb: JTypeBuilder[T]): F[T]
    def bytesBuilder(tb: JTypeBuilder[T]): F[JBytesBuilder[T]]
    def bytesType(tb: JTypeBuilder[T]): F[T]
    def doubleBuilder(tb: JTypeBuilder[T]): F[JDoubleBuilder[T]]
    def doubleType(tb: JTypeBuilder[T]): F[T]
    def enumeration(tb: JTypeBuilder[T])(name: String): F[JEnumBuilder[T]]
    def fixed(tb: JTypeBuilder[T])(name: String): F[JFixedBuilder[T]]
    def floatBuilder(tb: JTypeBuilder[T]): F[JFloatBuilder[T]]
    def floatType(tb: JTypeBuilder[T]): F[T]
    def intBuilder(tb: JTypeBuilder[T]): F[JIntBuilder[T]]
    def intType(tb: JTypeBuilder[T]): F[T]
    def longBuilder(tb: JTypeBuilder[T]): F[JLongBuilder[T]]
    def longType(tb: JTypeBuilder[T]): F[T]
    def map(tb: JTypeBuilder[T]): F[JMapBuilder[T]]
    def nullBuilder(tb: JTypeBuilder[T]): F[JNullBuilder[T]]
    def nullType(tb: JTypeBuilder[T]): F[T]
    def record(tb: JTypeBuilder[T])(name: String): F[JRecordBuilder[T]]
    def stringBuilder(tb: JTypeBuilder[T]): F[JStringBuilder[T]]
    def stringType(tb: JTypeBuilder[T]): F[T]
    def `type`(tb: JTypeBuilder[T])(schema: Schema): F[T]
    def `type`(tb: JTypeBuilder[T])(name: String): F[T]
    def `type`(tb: JTypeBuilder[T])(name: String, namespace: String): F[T]
    def unionOf(tb: JTypeBuilder[T]): F[JBaseTypeBuilder[JUnionAccumulator[T]]]    
  object TypeBuilder:
    given [F[_]: Sync, T]: TypeBuilder[F, T] =
      new TypeBuilder[F, T]:
        def array(tb: JTypeBuilder[T]): F[JArrayBuilder[T]] =
          Sync[F].delay(tb.array())
        def booleanBuilder(tb: JTypeBuilder[T]): F[JBooleanBuilder[T]] =
          Sync[F].delay(tb.booleanBuilder())
        def booleanType(tb: JTypeBuilder[T]): F[T] =
          Sync[F].delay(tb.booleanType())
        def bytesBuilder(tb: JTypeBuilder[T]): F[JBytesBuilder[T]] =
          Sync[F].delay(tb.bytesBuilder())
        def bytesType(tb: JTypeBuilder[T]): F[T] =
          Sync[F].delay(tb.bytesType())
        def doubleBuilder(tb: JTypeBuilder[T]): F[JDoubleBuilder[T]] =
          Sync[F].delay(tb.doubleBuilder())
        def doubleType(tb: JTypeBuilder[T]): F[T] =
          Sync[F].delay(tb.doubleType())
        def enumeration(tb: JTypeBuilder[T])(name: String): F[JEnumBuilder[T]] =
          Sync[F].delay(tb.enumeration(name))
        def fixed(tb: JTypeBuilder[T])(name: String): F[JFixedBuilder[T]] =
          Sync[F].delay(tb.fixed(name))
        def floatBuilder(tb: JTypeBuilder[T]): F[JFloatBuilder[T]] =
          Sync[F].delay(tb.floatBuilder())
        def floatType(tb: JTypeBuilder[T]): F[T] =
          Sync[F].delay(tb.floatType())
        def intBuilder(tb: JTypeBuilder[T]): F[JIntBuilder[T]] =
          Sync[F].delay(tb.intBuilder())
        def intType(tb: JTypeBuilder[T]): F[T] =
          Sync[F].delay(tb.intType())
        def longBuilder(tb: JTypeBuilder[T]): F[JLongBuilder[T]] =
          Sync[F].delay(tb.longBuilder())
        def longType(tb: JTypeBuilder[T]): F[T] =
          Sync[F].delay(tb.longType())
        def map(tb: JTypeBuilder[T]): F[JMapBuilder[T]] =
          Sync[F].delay(tb.map())
        def nullBuilder(tb: JTypeBuilder[T]): F[JNullBuilder[T]] =
          Sync[F].delay(tb.nullBuilder())
        def nullType(tb: JTypeBuilder[T]): F[T] =
          Sync[F].delay(tb.nullType())
        def record(tb: JTypeBuilder[T])(name: String): F[JRecordBuilder[T]] =
          Sync[F].delay(tb.record(name))
        def stringBuilder(tb: JTypeBuilder[T]): F[JStringBuilder[T]] =
          Sync[F].delay(tb.stringBuilder())
        def stringType(tb: JTypeBuilder[T]): F[T] =
          Sync[F].delay(tb.stringType())
        def `type`(tb: JTypeBuilder[T])(schema: Schema): F[T] =
          Sync[F].delay(tb.`type`(schema))
        def `type`(tb: JTypeBuilder[T])(name: String): F[T] =
          Sync[F].delay(tb.`type`(name))
        def `type`(tb: JTypeBuilder[T])(name: String, namespace: String): F[T] =
          Sync[F].delay(tb.`type`(name, namespace))
        def unionOf(tb: JTypeBuilder[T]): F[JBaseTypeBuilder[JUnionAccumulator[T]]] =
          Sync[F].delay(tb.unionOf())

  trait UnionAccumulator[F[_], T]:
    def and(ua: JUnionAccumulator[T]): F[JBaseTypeBuilder[JUnionAccumulator[T]]]
    def endUnion(ua: JUnionAccumulator[T]): F[T]    
  object UnionAccumulator:
    given [F[_]: Sync, T]: UnionAccumulator[F, T] =
      new UnionAccumulator[F, T]:
        def and(ua: JUnionAccumulator[T]): F[JBaseTypeBuilder[JUnionAccumulator[T]]] =
          Sync[F].delay(ua.and())
        def endUnion(ua: JUnionAccumulator[T]): F[T] =
          Sync[F].delay(ua.endUnion())

  trait UnionFieldTypeBuilder[F[_], T]:
    def array(uftb: JUnionFieldTypeBuilder[T]): F[JArrayBuilder[JUnionAccumulator[JArrayDefault[T]]]]
    def booleanBuilder(uftb: JUnionFieldTypeBuilder[T]): F[JBooleanBuilder[JUnionAccumulator[JBooleanDefault[T]]]]
    def booleanType(uftb: JUnionFieldTypeBuilder[T]): F[JUnionAccumulator[JBooleanDefault[T]]]
    def bytesBuilder(uftb: JUnionFieldTypeBuilder[T]): F[JBytesBuilder[JUnionAccumulator[JBytesDefault[T]]]]
    def bytesType(uftb: JUnionFieldTypeBuilder[T]): F[JUnionAccumulator[JBytesDefault[T]]]
    def doubleBuilder(uftb: JUnionFieldTypeBuilder[T]): F[JDoubleBuilder[JUnionAccumulator[JDoubleDefault[T]]]]
    def doubleType(uftb: JUnionFieldTypeBuilder[T]): F[JUnionAccumulator[JDoubleDefault[T]]]
    def enumeration(uftb: JUnionFieldTypeBuilder[T])(name: String): F[JEnumBuilder[JUnionAccumulator[JEnumDefault[T]]]]
    def fixed(uftb: JUnionFieldTypeBuilder[T])(name: String): F[JFixedBuilder[JUnionAccumulator[JFixedDefault[T]]]]
    def floatBuilder(uftb: JUnionFieldTypeBuilder[T]): F[JFloatBuilder[JUnionAccumulator[JFloatDefault[T]]]]
    def floatType(uftb: JUnionFieldTypeBuilder[T]): F[JUnionAccumulator[JFloatDefault[T]]]
    def intBuilder(uftb: JUnionFieldTypeBuilder[T]): F[JIntBuilder[JUnionAccumulator[JIntDefault[T]]]]
    def intType(uftb: JUnionFieldTypeBuilder[T]): F[JUnionAccumulator[JIntDefault[T]]]
    def longBuilder(uftb: JUnionFieldTypeBuilder[T]): F[JLongBuilder[JUnionAccumulator[JLongDefault[T]]]]
    def longType(uftb: JUnionFieldTypeBuilder[T]): F[JUnionAccumulator[JLongDefault[T]]]
    def map(uftb: JUnionFieldTypeBuilder[T]): F[JMapBuilder[JUnionAccumulator[JMapDefault[T]]]]
    def nullBuilder(uftb: JUnionFieldTypeBuilder[T]): F[JNullBuilder[JUnionAccumulator[JNullDefault[T]]]]
    def nullType(uftb: JUnionFieldTypeBuilder[T]): F[JUnionAccumulator[JNullDefault[T]]]
    def record(uftb: JUnionFieldTypeBuilder[T])(name: String): F[JRecordBuilder[JUnionAccumulator[JRecordDefault[T]]]]
    def stringBuilder(uftb: JUnionFieldTypeBuilder[T]): F[JStringBuilder[JUnionAccumulator[JStringDefault[T]]]]
    def stringType(uftb: JUnionFieldTypeBuilder[T]): F[JUnionAccumulator[JStringDefault[T]]]

  object UnionFieldTypeBuilder:
    given [F[_]: Sync, T]: UnionFieldTypeBuilder[F, T] =
      new UnionFieldTypeBuilder[F, T]:
        def array(uftb: JUnionFieldTypeBuilder[T]): F[JArrayBuilder[JUnionAccumulator[JArrayDefault[T]]]] =
          Sync[F].delay(uftb.array())
        def booleanBuilder(uftb: JUnionFieldTypeBuilder[T]): F[JBooleanBuilder[JUnionAccumulator[JBooleanDefault[T]]]] =
          Sync[F].delay(uftb.booleanBuilder())
        def booleanType(uftb: JUnionFieldTypeBuilder[T]): F[JUnionAccumulator[JBooleanDefault[T]]] =
          Sync[F].delay(uftb.booleanType())
        def bytesBuilder(uftb: JUnionFieldTypeBuilder[T]): F[JBytesBuilder[JUnionAccumulator[JBytesDefault[T]]]] =
          Sync[F].delay(uftb.bytesBuilder())
        def bytesType(uftb: JUnionFieldTypeBuilder[T]): F[JUnionAccumulator[JBytesDefault[T]]] =
          Sync[F].delay(uftb.bytesType())
        def doubleBuilder(uftb: JUnionFieldTypeBuilder[T]): F[JDoubleBuilder[JUnionAccumulator[JDoubleDefault[T]]]] =
          Sync[F].delay(uftb.doubleBuilder())
        def doubleType(uftb: JUnionFieldTypeBuilder[T]): F[JUnionAccumulator[JDoubleDefault[T]]] =
          Sync[F].delay(uftb.doubleType())
        def enumeration(uftb: JUnionFieldTypeBuilder[T])(name: String): F[JEnumBuilder[JUnionAccumulator[JEnumDefault[T]]]] =
          Sync[F].delay(uftb.enumeration(name))
        def fixed(uftb: JUnionFieldTypeBuilder[T])(name: String): F[JFixedBuilder[JUnionAccumulator[JFixedDefault[T]]]] =
          Sync[F].delay(uftb.fixed(name))
        def floatBuilder(uftb: JUnionFieldTypeBuilder[T]): F[JFloatBuilder[JUnionAccumulator[JFloatDefault[T]]]] =
          Sync[F].delay(uftb.floatBuilder())
        def floatType(uftb: JUnionFieldTypeBuilder[T]): F[JUnionAccumulator[JFloatDefault[T]]] =
          Sync[F].delay(uftb.floatType())
        def intBuilder(uftb: JUnionFieldTypeBuilder[T]): F[JIntBuilder[JUnionAccumulator[JIntDefault[T]]]] =
          Sync[F].delay(uftb.intBuilder())
        def intType(uftb: JUnionFieldTypeBuilder[T]): F[JUnionAccumulator[JIntDefault[T]]] =
          Sync[F].delay(uftb.intType())
        def longBuilder(uftb: JUnionFieldTypeBuilder[T]): F[JLongBuilder[JUnionAccumulator[JLongDefault[T]]]] =
          Sync[F].delay(uftb.longBuilder())
        def longType(uftb: JUnionFieldTypeBuilder[T]): F[JUnionAccumulator[JLongDefault[T]]] =
          Sync[F].delay(uftb.longType())
        def map(uftb: JUnionFieldTypeBuilder[T]): F[JMapBuilder[JUnionAccumulator[JMapDefault[T]]]] =
          Sync[F].delay(uftb.map())
        def nullBuilder(uftb: JUnionFieldTypeBuilder[T]): F[JNullBuilder[JUnionAccumulator[JNullDefault[T]]]] =
          Sync[F].delay(uftb.nullBuilder())
        def nullType(uftb: JUnionFieldTypeBuilder[T]): F[JUnionAccumulator[JNullDefault[T]]] =
          Sync[F].delay(uftb.nullType())
        def record(uftb: JUnionFieldTypeBuilder[T])(name: String): F[JRecordBuilder[JUnionAccumulator[JRecordDefault[T]]]] =
          Sync[F].delay(uftb.record(name))
        def stringBuilder(uftb: JUnionFieldTypeBuilder[T]): F[JStringBuilder[JUnionAccumulator[JStringDefault[T]]]] =
          Sync[F].delay(uftb.stringBuilder())
        def stringType(uftb: JUnionFieldTypeBuilder[T]): F[JUnionAccumulator[JStringDefault[T]]] =
          Sync[F].delay(uftb.stringType())