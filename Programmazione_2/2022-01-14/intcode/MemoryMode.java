package intcode;

public enum MemoryMode {
    DIRECT_ACCESS,
    PARAMETER_VALUE,
    UNDIRECT_ACCESS;

    public static MemoryMode fromInteger(Integer i) {
        switch (i) {
            case 0:
                return DIRECT_ACCESS;
            
            case 1:
                return PARAMETER_VALUE;

            case 2:
                return UNDIRECT_ACCESS;
        }
        return DIRECT_ACCESS;
    }
}
