// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: DataInfoPra.proto

package my.suveng.netty.learn.protobuf;

@SuppressWarnings(value = "all")
public final class DataInfoPra {
    private DataInfoPra() {
    }

    public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
        registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
    }

    public interface InfoOrBuilder extends
            // @@protoc_insertion_point(interface_extends:my.suveng.protobuf.Info)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>optional string name = 1;</code>
         * 
         * @return Whether the name field is set.
         */
        boolean hasName();

        /**
         * <code>optional string name = 1;</code>
         * 
         * @return The name.
         */
        java.lang.String getName();

        /**
         * <code>optional string name = 1;</code>
         * 
         * @return The bytes for name.
         */
        com.google.protobuf.ByteString getNameBytes();

        /**
         * <code>optional string age = 2;</code>
         * 
         * @return Whether the age field is set.
         */
        boolean hasAge();

        /**
         * <code>optional string age = 2;</code>
         * 
         * @return The age.
         */
        java.lang.String getAge();

        /**
         * <code>optional string age = 2;</code>
         * 
         * @return The bytes for age.
         */
        com.google.protobuf.ByteString getAgeBytes();

        /**
         * <code>optional string time = 3;</code>
         * 
         * @return Whether the time field is set.
         */
        boolean hasTime();

        /**
         * <code>optional string time = 3;</code>
         * 
         * @return The time.
         */
        java.lang.String getTime();

        /**
         * <code>optional string time = 3;</code>
         * 
         * @return The bytes for time.
         */
        com.google.protobuf.ByteString getTimeBytes();
    }

    /**
     * Protobuf type {@code my.suveng.protobuf.Info}
     */
    public static final class Info extends com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:my.suveng.protobuf.Info)
            InfoOrBuilder {
        private static final long serialVersionUID = 0L;

        // Use Info.newBuilder() to construct.
        private Info(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private Info() {
            name_ = "";
            age_ = "";
            time_ = "";
        }

        @java.lang.Override
        @SuppressWarnings({ "unused" })
        protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
            return new Info();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Info(com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields = com.google.protobuf.UnknownFieldSet
                    .newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                    case 0:
                        done = true;
                        break;
                    case 10: {
                        com.google.protobuf.ByteString bs = input.readBytes();
                        bitField0_ |= 0x00000001;
                        name_ = bs;
                        break;
                    }
                    case 18: {
                        com.google.protobuf.ByteString bs = input.readBytes();
                        bitField0_ |= 0x00000002;
                        age_ = bs;
                        break;
                    }
                    case 26: {
                        com.google.protobuf.ByteString bs = input.readBytes();
                        bitField0_ |= 0x00000004;
                        time_ = bs;
                        break;
                    }
                    default: {
                        if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                            done = true;
                        }
                        break;
                    }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return my.suveng.netty.learn.protobuf.DataInfoPra.internal_static_my_suveng_protobuf_Info_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return my.suveng.netty.learn.protobuf.DataInfoPra.internal_static_my_suveng_protobuf_Info_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(my.suveng.netty.learn.protobuf.DataInfoPra.Info.class,
                            my.suveng.netty.learn.protobuf.DataInfoPra.Info.Builder.class);
        }

        private int bitField0_;
        public static final int NAME_FIELD_NUMBER = 1;
        private volatile java.lang.Object name_;

        /**
         * <code>optional string name = 1;</code>
         * 
         * @return Whether the name field is set.
         */
        public boolean hasName() {
            return ((bitField0_ & 0x00000001) != 0);
        }

        /**
         * <code>optional string name = 1;</code>
         * 
         * @return The name.
         */
        public java.lang.String getName() {
            java.lang.Object ref = name_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    name_ = s;
                }
                return s;
            }
        }

        /**
         * <code>optional string name = 1;</code>
         * 
         * @return The bytes for name.
         */
        public com.google.protobuf.ByteString getNameBytes() {
            java.lang.Object ref = name_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
                name_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int AGE_FIELD_NUMBER = 2;
        private volatile java.lang.Object age_;

        /**
         * <code>optional string age = 2;</code>
         * 
         * @return Whether the age field is set.
         */
        public boolean hasAge() {
            return ((bitField0_ & 0x00000002) != 0);
        }

        /**
         * <code>optional string age = 2;</code>
         * 
         * @return The age.
         */
        public java.lang.String getAge() {
            java.lang.Object ref = age_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    age_ = s;
                }
                return s;
            }
        }

        /**
         * <code>optional string age = 2;</code>
         * 
         * @return The bytes for age.
         */
        public com.google.protobuf.ByteString getAgeBytes() {
            java.lang.Object ref = age_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
                age_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int TIME_FIELD_NUMBER = 3;
        private volatile java.lang.Object time_;

        /**
         * <code>optional string time = 3;</code>
         * 
         * @return Whether the time field is set.
         */
        public boolean hasTime() {
            return ((bitField0_ & 0x00000004) != 0);
        }

        /**
         * <code>optional string time = 3;</code>
         * 
         * @return The time.
         */
        public java.lang.String getTime() {
            java.lang.Object ref = time_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    time_ = s;
                }
                return s;
            }
        }

        /**
         * <code>optional string time = 3;</code>
         * 
         * @return The bytes for time.
         */
        @Override
        public com.google.protobuf.ByteString getTimeBytes() {
            java.lang.Object ref = time_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
                time_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        private byte memoizedIsInitialized = -1;

        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;

            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
            if (((bitField0_ & 0x00000001) != 0)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 1, name_);
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 2, age_);
            }
            if (((bitField0_ & 0x00000004) != 0)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 3, time_);
            }
            unknownFields.writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1)
                return size;

            size = 0;
            if (((bitField0_ & 0x00000001) != 0)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, name_);
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, age_);
            }
            if (((bitField0_ & 0x00000004) != 0)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, time_);
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
            if (!(obj instanceof my.suveng.netty.learn.protobuf.DataInfoPra.Info)) {
                return super.equals(obj);
            }
            my.suveng.netty.learn.protobuf.DataInfoPra.Info other = (my.suveng.netty.learn.protobuf.DataInfoPra.Info) obj;

            if (hasName() != other.hasName())
                return false;
            if (hasName()) {
                if (!getName().equals(other.getName()))
                    return false;
            }
            if (hasAge() != other.hasAge())
                return false;
            if (hasAge()) {
                if (!getAge().equals(other.getAge()))
                    return false;
            }
            if (hasTime() != other.hasTime())
                return false;
            if (hasTime()) {
                if (!getTime().equals(other.getTime()))
                    return false;
            }
            if (!unknownFields.equals(other.unknownFields))
                return false;
            return true;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (hasName()) {
                hash = (37 * hash) + NAME_FIELD_NUMBER;
                hash = (53 * hash) + getName().hashCode();
            }
            if (hasAge()) {
                hash = (37 * hash) + AGE_FIELD_NUMBER;
                hash = (53 * hash) + getAge().hashCode();
            }
            if (hasTime()) {
                hash = (37 * hash) + TIME_FIELD_NUMBER;
                hash = (53 * hash) + getTime().hashCode();
            }
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static my.suveng.netty.learn.protobuf.DataInfoPra.Info parseFrom(java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static my.suveng.netty.learn.protobuf.DataInfoPra.Info parseFrom(java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static my.suveng.netty.learn.protobuf.DataInfoPra.Info parseFrom(com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static my.suveng.netty.learn.protobuf.DataInfoPra.Info parseFrom(com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static my.suveng.netty.learn.protobuf.DataInfoPra.Info parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static my.suveng.netty.learn.protobuf.DataInfoPra.Info parseFrom(byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static my.suveng.netty.learn.protobuf.DataInfoPra.Info parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static my.suveng.netty.learn.protobuf.DataInfoPra.Info parseFrom(java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static my.suveng.netty.learn.protobuf.DataInfoPra.Info parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static my.suveng.netty.learn.protobuf.DataInfoPra.Info parseDelimitedFrom(java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input,
                    extensionRegistry);
        }

        public static my.suveng.netty.learn.protobuf.DataInfoPra.Info parseFrom(
                com.google.protobuf.CodedInputStream input) throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static my.suveng.netty.learn.protobuf.DataInfoPra.Info parseFrom(
                com.google.protobuf.CodedInputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @java.lang.Override
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(my.suveng.netty.learn.protobuf.DataInfoPra.Info prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @java.lang.Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        /**
         * Protobuf type {@code my.suveng.protobuf.Info}
         */
        public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:my.suveng.protobuf.Info)
                my.suveng.netty.learn.protobuf.DataInfoPra.InfoOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
                return my.suveng.netty.learn.protobuf.DataInfoPra.internal_static_my_suveng_protobuf_Info_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return my.suveng.netty.learn.protobuf.DataInfoPra.internal_static_my_suveng_protobuf_Info_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(my.suveng.netty.learn.protobuf.DataInfoPra.Info.class,
                                my.suveng.netty.learn.protobuf.DataInfoPra.Info.Builder.class);
            }

            // Construct using my.suveng.netty.learn.protobuf.DataInfoPra.Info.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
                }
            }

            @java.lang.Override
            public Builder clear() {
                super.clear();
                name_ = "";
                bitField0_ = (bitField0_ & ~0x00000001);
                age_ = "";
                bitField0_ = (bitField0_ & ~0x00000002);
                time_ = "";
                bitField0_ = (bitField0_ & ~0x00000004);
                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
                return my.suveng.netty.learn.protobuf.DataInfoPra.internal_static_my_suveng_protobuf_Info_descriptor;
            }

            @java.lang.Override
            public my.suveng.netty.learn.protobuf.DataInfoPra.Info getDefaultInstanceForType() {
                return my.suveng.netty.learn.protobuf.DataInfoPra.Info.getDefaultInstance();
            }

            @java.lang.Override
            public my.suveng.netty.learn.protobuf.DataInfoPra.Info build() {
                my.suveng.netty.learn.protobuf.DataInfoPra.Info result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public my.suveng.netty.learn.protobuf.DataInfoPra.Info buildPartial() {
                my.suveng.netty.learn.protobuf.DataInfoPra.Info result = new my.suveng.netty.learn.protobuf.DataInfoPra.Info(
                        this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) != 0)) {
                    to_bitField0_ |= 0x00000001;
                }
                result.name_ = name_;
                if (((from_bitField0_ & 0x00000002) != 0)) {
                    to_bitField0_ |= 0x00000002;
                }
                result.age_ = age_;
                if (((from_bitField0_ & 0x00000004) != 0)) {
                    to_bitField0_ |= 0x00000004;
                }
                result.time_ = time_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder clone() {
                return super.clone();
            }

            @java.lang.Override
            public Builder setField(com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
                return super.setField(field, value);
            }

            @java.lang.Override
            public Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }

            @java.lang.Override
            public Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }

            @java.lang.Override
            public Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor field, int index,
                    java.lang.Object value) {
                return super.setRepeatedField(field, index, value);
            }

            @java.lang.Override
            public Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.addRepeatedField(field, value);
            }

            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof my.suveng.netty.learn.protobuf.DataInfoPra.Info) {
                    return mergeFrom((my.suveng.netty.learn.protobuf.DataInfoPra.Info) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(my.suveng.netty.learn.protobuf.DataInfoPra.Info other) {
                if (other == my.suveng.netty.learn.protobuf.DataInfoPra.Info.getDefaultInstance())
                    return this;
                if (other.hasName()) {
                    bitField0_ |= 0x00000001;
                    name_ = other.name_;
                    onChanged();
                }
                if (other.hasAge()) {
                    bitField0_ |= 0x00000002;
                    age_ = other.age_;
                    onChanged();
                }
                if (other.hasTime()) {
                    bitField0_ |= 0x00000004;
                    time_ = other.time_;
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
            public Builder mergeFrom(com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
                my.suveng.netty.learn.protobuf.DataInfoPra.Info parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (my.suveng.netty.learn.protobuf.DataInfoPra.Info) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private int bitField0_;

            private java.lang.Object name_ = "";

            /**
             * <code>optional string name = 1;</code>
             * 
             * @return Whether the name field is set.
             */
            public boolean hasName() {
                return ((bitField0_ & 0x00000001) != 0);
            }

            /**
             * <code>optional string name = 1;</code>
             * 
             * @return The name.
             */
            public java.lang.String getName() {
                java.lang.Object ref = name_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        name_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }

            /**
             * <code>optional string name = 1;</code>
             * 
             * @return The bytes for name.
             */
            public com.google.protobuf.ByteString getNameBytes() {
                java.lang.Object ref = name_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b = com.google.protobuf.ByteString
                            .copyFromUtf8((java.lang.String) ref);
                    name_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <code>optional string name = 1;</code>
             * 
             * @param value
             *            The name to set.
             * 
             * @return This builder for chaining.
             */
            public Builder setName(java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                name_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional string name = 1;</code>
             * 
             * @return This builder for chaining.
             */
            public Builder clearName() {
                bitField0_ = (bitField0_ & ~0x00000001);
                name_ = getDefaultInstance().getName();
                onChanged();
                return this;
            }

            /**
             * <code>optional string name = 1;</code>
             * 
             * @param value
             *            The bytes for name to set.
             * 
             * @return This builder for chaining.
             */
            public Builder setNameBytes(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                name_ = value;
                onChanged();
                return this;
            }

            private java.lang.Object age_ = "";

            /**
             * <code>optional string age = 2;</code>
             * 
             * @return Whether the age field is set.
             */
            public boolean hasAge() {
                return ((bitField0_ & 0x00000002) != 0);
            }

            /**
             * <code>optional string age = 2;</code>
             * 
             * @return The age.
             */
            public java.lang.String getAge() {
                java.lang.Object ref = age_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        age_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }

            /**
             * <code>optional string age = 2;</code>
             * 
             * @return The bytes for age.
             */
            public com.google.protobuf.ByteString getAgeBytes() {
                java.lang.Object ref = age_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b = com.google.protobuf.ByteString
                            .copyFromUtf8((java.lang.String) ref);
                    age_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <code>optional string age = 2;</code>
             * 
             * @param value
             *            The age to set.
             * 
             * @return This builder for chaining.
             */
            public Builder setAge(java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000002;
                age_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional string age = 2;</code>
             * 
             * @return This builder for chaining.
             */
            public Builder clearAge() {
                bitField0_ = (bitField0_ & ~0x00000002);
                age_ = getDefaultInstance().getAge();
                onChanged();
                return this;
            }

            /**
             * <code>optional string age = 2;</code>
             * 
             * @param value
             *            The bytes for age to set.
             * 
             * @return This builder for chaining.
             */
            public Builder setAgeBytes(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000002;
                age_ = value;
                onChanged();
                return this;
            }

            private java.lang.Object time_ = "";

            /**
             * <code>optional string time = 3;</code>
             * 
             * @return Whether the time field is set.
             */
            public boolean hasTime() {
                return ((bitField0_ & 0x00000004) != 0);
            }

            /**
             * <code>optional string time = 3;</code>
             * 
             * @return The time.
             */
            public java.lang.String getTime() {
                java.lang.Object ref = time_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        time_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }

            /**
             * <code>optional string time = 3;</code>
             * 
             * @return The bytes for time.
             */
            @Override
            public com.google.protobuf.ByteString getTimeBytes() {
                java.lang.Object ref = time_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b = com.google.protobuf.ByteString
                            .copyFromUtf8((java.lang.String) ref);
                    time_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <code>optional string time = 3;</code>
             * 
             * @param value
             *            The time to set.
             * 
             * @return This builder for chaining.
             */
            public Builder setTime(java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000004;
                time_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional string time = 3;</code>
             * 
             * @return This builder for chaining.
             */
            public Builder clearTime() {
                bitField0_ = (bitField0_ & ~0x00000004);
                time_ = getDefaultInstance().getTime();
                onChanged();
                return this;
            }

            /**
             * <code>optional string time = 3;</code>
             * 
             * @param value
             *            The bytes for time to set.
             * 
             * @return This builder for chaining.
             */
            public Builder setTimeBytes(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000004;
                time_ = value;
                onChanged();
                return this;
            }

            @java.lang.Override
            public final Builder setUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @java.lang.Override
            public final Builder mergeUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }

            // @@protoc_insertion_point(builder_scope:my.suveng.protobuf.Info)
        }

        // @@protoc_insertion_point(class_scope:my.suveng.protobuf.Info)
        private static final my.suveng.netty.learn.protobuf.DataInfoPra.Info DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new my.suveng.netty.learn.protobuf.DataInfoPra.Info();
        }

        public static my.suveng.netty.learn.protobuf.DataInfoPra.Info getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @java.lang.Deprecated
        public static final com.google.protobuf.Parser<Info> PARSER = new com.google.protobuf.AbstractParser<Info>() {
            @java.lang.Override
            public Info parsePartialFrom(com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new Info(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<Info> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<Info> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public my.suveng.netty.learn.protobuf.DataInfoPra.Info getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    private static final com.google.protobuf.Descriptors.Descriptor internal_static_my_suveng_protobuf_Info_descriptor;
    private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_my_suveng_protobuf_Info_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

    static {
        java.lang.String[] descriptorData = { "\n\021DataInfoPra.proto\022\022my.suveng.protobuf\""
                + "/\n\004Info\022\014\n\004name\030\001 \001(\t\022\013\n\003age\030\002 \001(\t\022\014\n\004ti"
                + "me\030\003 \001(\tB/\n\036my.suveng.netty.learn.protob" + "ufB\013DataInfoPraH\001" };
        descriptor = com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData,
                new com.google.protobuf.Descriptors.FileDescriptor[] {});
        internal_static_my_suveng_protobuf_Info_descriptor = getDescriptor().getMessageTypes().get(0);
        internal_static_my_suveng_protobuf_Info_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_my_suveng_protobuf_Info_descriptor, new java.lang.String[] { "Name", "Age", "Time", });
    }

    // @@protoc_insertion_point(outer_class_scope)
}
