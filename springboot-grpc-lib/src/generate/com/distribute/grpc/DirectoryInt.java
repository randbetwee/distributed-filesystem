// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: directory.proto

package com.distribute.grpc;

public final class DirectoryInt {
  private DirectoryInt() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_LsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_LsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_MkdirResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_MkdirResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017directory.proto\"\031\n\tLsRequest\022\014\n\004path\030\001" +
      " \001(\t\"\037\n\nLsResponse\022\021\n\tfilenames\030\001 \003(\t\"\037\n" +
      "\rMkdirResponse\022\016\n\006status\030\001 \001(\0102x\n\020Direct" +
      "oryService\022\035\n\002Ls\022\n.LsRequest\032\013.LsRespons" +
      "e\022#\n\005mkdir\022\n.LsRequest\032\016.MkdirResponse\022 " +
      "\n\002cd\022\n.LsRequest\032\016.MkdirResponseB(\n\023com." +
      "distribute.grpcB\014DirectoryIntP\001\210\001\001b\006prot" +
      "o3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_LsRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_LsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_LsRequest_descriptor,
        new java.lang.String[] { "Path", });
    internal_static_LsResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_LsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_LsResponse_descriptor,
        new java.lang.String[] { "Filenames", });
    internal_static_MkdirResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_MkdirResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_MkdirResponse_descriptor,
        new java.lang.String[] { "Status", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
