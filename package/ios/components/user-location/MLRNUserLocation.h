//
//  MLRNUserLocation.h
//  MLRN

#import <CoreLocation/CoreLocation.h>
#import <Foundation/Foundation.h>
#import <MapVina/MLNUserLocationAnnotationView.h>

@interface MLRNUserLocation : NSObject

+ (id)sharedInstance;

- (MLNUserLocationAnnotationView*)hiddenUserAnnotation;

@end
