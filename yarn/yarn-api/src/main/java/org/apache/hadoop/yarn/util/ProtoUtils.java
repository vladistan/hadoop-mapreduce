package org.apache.hadoop.yarn.util;

import java.nio.ByteBuffer;

import org.apache.hadoop.yarn.api.records.ApplicationState;
import org.apache.hadoop.yarn.api.records.ContainerState;
import org.apache.hadoop.yarn.api.records.LocalResourceType;
import org.apache.hadoop.yarn.api.records.LocalResourceVisibility;
import org.apache.hadoop.yarn.api.records.YarnContainerTags;
import org.apache.hadoop.yarn.proto.YarnProtos.ApplicationStateProto;
import org.apache.hadoop.yarn.proto.YarnProtos.ContainerStateProto;
import org.apache.hadoop.yarn.proto.YarnProtos.LocalResourceTypeProto;
import org.apache.hadoop.yarn.proto.YarnProtos.LocalResourceVisibilityProto;
import org.apache.hadoop.yarn.proto.YarnProtos.YarnContainerTagsProto;

import com.google.protobuf.ByteString;

public class ProtoUtils {
  
  
  /*
   * ContainerState
   */
  private static String CONTAINER_STATE_PREFIX = "C_";
  public static ContainerStateProto convertToProtoFormat(ContainerState e) {
    return ContainerStateProto.valueOf(CONTAINER_STATE_PREFIX + e.name());
  }
  public static ContainerState convertFromProtoFormat(ContainerStateProto e) {
    return ContainerState.valueOf(e.name().replace(CONTAINER_STATE_PREFIX, ""));
  }
  

  /*
   * ApplicationState
   */
  public static ApplicationStateProto convertToProtoFormat(ApplicationState e) {
    return ApplicationStateProto.valueOf(e.name());
  }
  public static ApplicationState convertFromProtoFormat(ApplicationStateProto e) {
    return ApplicationState.valueOf(e.name());
  }
  
  /*
   * LocalResourceType
   */
  public static LocalResourceTypeProto convertToProtoFormat(LocalResourceType e) {
    return LocalResourceTypeProto.valueOf(e.name());
  }
  public static LocalResourceType convertFromProtoFormat(LocalResourceTypeProto e) {
    return LocalResourceType.valueOf(e.name());
  }
  
  /*
   * LocalResourceVisibility
   */
  public static LocalResourceVisibilityProto convertToProtoFormat(LocalResourceVisibility e) {
    return LocalResourceVisibilityProto.valueOf(e.name());
  }
  public static LocalResourceVisibility convertFromProtoFormat(LocalResourceVisibilityProto e) {
    return LocalResourceVisibility.valueOf(e.name());
  }
  
  /*
   * YarnContainerTags
   */
  public static YarnContainerTagsProto convertToProtoFormat(YarnContainerTags e) {
    return YarnContainerTagsProto.valueOf(e.name());
  }
  public static YarnContainerTags convertFromProtoFormat(YarnContainerTagsProto e) {
    return YarnContainerTags.valueOf(e.name());
  }
  
  /*
   * ByteBuffer
   */
  public static ByteBuffer convertFromProtoFormat(ByteString byteString) {
    int capacity = byteString.asReadOnlyByteBuffer().rewind().remaining();
    byte[] b = new byte[capacity];
    byteString.asReadOnlyByteBuffer().get(b, 0, capacity);
    return ByteBuffer.wrap(b);
  }

  public static ByteString convertToProtoFormat(ByteBuffer byteBuffer) {
//    return ByteString.copyFrom((ByteBuffer)byteBuffer.duplicate().rewind());
    int oldPos = byteBuffer.position();
    byteBuffer.rewind();
    ByteString bs = ByteString.copyFrom(byteBuffer);
    byteBuffer.position(oldPos);
    return bs;
  }
  
}