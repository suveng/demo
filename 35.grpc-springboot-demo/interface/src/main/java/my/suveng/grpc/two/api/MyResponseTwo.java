// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: newTest.proto

package my.suveng.grpc.two.api;

/**
 * Protobuf type {@code MyResponseTwo}
 */
public final class MyResponseTwo extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:MyResponseTwo)
    MyResponseTwoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use MyResponseTwo.newBuilder() to construct.
  private MyResponseTwo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MyResponseTwo() {
    realname_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new MyResponseTwo();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private MyResponseTwo(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            realname_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return my.suveng.grpc.two.api.StudentTwo.internal_static_MyResponseTwo_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return my.suveng.grpc.two.api.StudentTwo.internal_static_MyResponseTwo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            my.suveng.grpc.two.api.MyResponseTwo.class, my.suveng.grpc.two.api.MyResponseTwo.Builder.class);
  }

  public static final int REALNAME_FIELD_NUMBER = 2;
  private volatile java.lang.Object realname_;
  /**
   * <code>string realname = 2;</code>
   * @return The realname.
   */
  @java.lang.Override
  public java.lang.String getRealname() {
    java.lang.Object ref = realname_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs =
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      realname_ = s;
      return s;
    }
  }
  /**
   * <code>string realname = 2;</code>
   * @return The bytes for realname.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getRealnameBytes() {
    java.lang.Object ref = realname_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      realname_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getRealnameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, realname_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getRealnameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, realname_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof my.suveng.grpc.two.api.MyResponseTwo)) {
      return super.equals(obj);
    }
    my.suveng.grpc.two.api.MyResponseTwo other = (my.suveng.grpc.two.api.MyResponseTwo) obj;

    if (!getRealname()
        .equals(other.getRealname())) return false;
	  return unknownFields.equals(other.unknownFields);
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + REALNAME_FIELD_NUMBER;
    hash = (53 * hash) + getRealname().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static my.suveng.grpc.two.api.MyResponseTwo parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static my.suveng.grpc.two.api.MyResponseTwo parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static my.suveng.grpc.two.api.MyResponseTwo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static my.suveng.grpc.two.api.MyResponseTwo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static my.suveng.grpc.two.api.MyResponseTwo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static my.suveng.grpc.two.api.MyResponseTwo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static my.suveng.grpc.two.api.MyResponseTwo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static my.suveng.grpc.two.api.MyResponseTwo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static my.suveng.grpc.two.api.MyResponseTwo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static my.suveng.grpc.two.api.MyResponseTwo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static my.suveng.grpc.two.api.MyResponseTwo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static my.suveng.grpc.two.api.MyResponseTwo parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(my.suveng.grpc.two.api.MyResponseTwo prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code MyResponseTwo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:MyResponseTwo)
      my.suveng.grpc.two.api.MyResponseTwoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return my.suveng.grpc.two.api.StudentTwo.internal_static_MyResponseTwo_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return my.suveng.grpc.two.api.StudentTwo.internal_static_MyResponseTwo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              my.suveng.grpc.two.api.MyResponseTwo.class, my.suveng.grpc.two.api.MyResponseTwo.Builder.class);
    }

    // Construct using my.suveng.grpc.two.api.MyResponseTwo.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      realname_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return my.suveng.grpc.two.api.StudentTwo.internal_static_MyResponseTwo_descriptor;
    }

    @java.lang.Override
    public my.suveng.grpc.two.api.MyResponseTwo getDefaultInstanceForType() {
      return my.suveng.grpc.two.api.MyResponseTwo.getDefaultInstance();
    }

    @java.lang.Override
    public my.suveng.grpc.two.api.MyResponseTwo build() {
      my.suveng.grpc.two.api.MyResponseTwo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public my.suveng.grpc.two.api.MyResponseTwo buildPartial() {
      my.suveng.grpc.two.api.MyResponseTwo result = new my.suveng.grpc.two.api.MyResponseTwo(this);
      result.realname_ = realname_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof my.suveng.grpc.two.api.MyResponseTwo) {
        return mergeFrom((my.suveng.grpc.two.api.MyResponseTwo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(my.suveng.grpc.two.api.MyResponseTwo other) {
      if (other == my.suveng.grpc.two.api.MyResponseTwo.getDefaultInstance()) return this;
      if (!other.getRealname().isEmpty()) {
        realname_ = other.realname_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      my.suveng.grpc.two.api.MyResponseTwo parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (my.suveng.grpc.two.api.MyResponseTwo) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object realname_ = "";
    /**
     * <code>string realname = 2;</code>
     * @return The realname.
     */
    public java.lang.String getRealname() {
      java.lang.Object ref = realname_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        realname_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string realname = 2;</code>
     * @return The bytes for realname.
     */
    public com.google.protobuf.ByteString
        getRealnameBytes() {
      java.lang.Object ref = realname_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        realname_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string realname = 2;</code>
     * @param value The realname to set.
     * @return This builder for chaining.
     */
    public Builder setRealname(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }

      realname_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string realname = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearRealname() {

      realname_ = getDefaultInstance().getRealname();
      onChanged();
      return this;
    }
    /**
     * <code>string realname = 2;</code>
     * @param value The bytes for realname to set.
     * @return This builder for chaining.
     */
    public Builder setRealnameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);

      realname_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:MyResponseTwo)
  }

  // @@protoc_insertion_point(class_scope:MyResponseTwo)
  private static final my.suveng.grpc.two.api.MyResponseTwo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new my.suveng.grpc.two.api.MyResponseTwo();
  }

  public static my.suveng.grpc.two.api.MyResponseTwo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MyResponseTwo>
      PARSER = new com.google.protobuf.AbstractParser<MyResponseTwo>() {
    @java.lang.Override
    public MyResponseTwo parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new MyResponseTwo(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<MyResponseTwo> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MyResponseTwo> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public my.suveng.grpc.two.api.MyResponseTwo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

