// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: test.proto

package my.suveng.grpc.api;

public final class Student {
  private Student() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_MyRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_MyRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_MyResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_MyResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\ntest.proto\"\035\n\tMyRequest\022\020\n\010username\030\001 " +
      "\001(\t\"\036\n\nMyResponse\022\020\n\010realname\030\002 \001(\t2\373\001\n\016" +
      "StudentService\0220\n\025getRealNameByUsername\022" +
      "\n.MyRequest\032\013.MyResponse\022;\n\036getRealNameB" +
      "yUsernameResStream\022\n.MyRequest\032\013.MyRespo" +
      "nse0\001\022;\n\036getRealNameByUsernameReqStream\022" +
      "\n.MyRequest\032\013.MyResponse(\001\022=\n\036getRealNam" +
      "eByUsernameStreamAll\022\n.MyRequest\032\013.MyRes" +
      "ponse(\0010\001B\037\n\022my.suveng.grpc.apiB\007Student" +
      "P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_MyRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_MyRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_MyRequest_descriptor,
        new java.lang.String[] { "Username", });
    internal_static_MyResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_MyResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_MyResponse_descriptor,
        new java.lang.String[] { "Realname", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
