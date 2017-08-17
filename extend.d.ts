import { IRNSimInfo } from './RNSimInfo'

declare module 'react-native' {
  export interface NativeModulesStatic {
    RNSimInfo: IRNSimInfo
  }
}
