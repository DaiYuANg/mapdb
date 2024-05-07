val devJvmArguments =
  listOf(
    "-XX:+UseZGC",
    "-XX:+ZGenerational",
    "-XX:+UseCompressedClassPointers",
    //    "-verbose:gc",
    "-Dcom.sun.management.jmxremote",
    "-XX:+UseStringDeduplication",
    "-XX:+OptimizeStringConcat",
    //    "-Xlog:gc*",
    //    "-Xlog:async",
    //    "-Xlog:os",
    //    "-Xlog:metaspace",
    "-Dcom.sun.management.jmxremote.port=9010",
    "-Dcom.sun.management.jmxremote.ssl=false",
    "-Dcom.sun.management.jmxremote.authenticate=false",
    "-XX:+UseCompressedOops",
    "-XX:MaxInlineLevel=32",
    "-XX:+AlwaysPreTouch",
    "-XX:+TieredCompilation",
    "-XX:SoftRefLRUPolicyMSPerMB=50",
    "-XX:+UseNUMA",
    "-Xmx256M",
    "-Dcom.sun.management.jmxremote",
  )
