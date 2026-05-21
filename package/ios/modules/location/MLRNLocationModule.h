#import <MapVinaReactNativeSpec/MapVinaReactNativeSpec.h>

#import "MLRNLocationManagerDelegate.h"

@interface MLRNLocationModule
    : NativeLocationModuleSpecBase <NativeLocationModuleSpec, MLRNLocationManagerDelegate>
@end
