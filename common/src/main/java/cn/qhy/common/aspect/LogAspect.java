// +----------------------------------------------------------------------
// | JavaWeb_Vue_Pro前后端分离旗舰版框架 [ JavaWeb ]
// +----------------------------------------------------------------------
// | 版权所有 2019~2020 南京JavaWeb研发中心
// +----------------------------------------------------------------------
// | 官方网站: http://www.javaweb.vip/
// +----------------------------------------------------------------------
// | 作者: 深圳汉云 <1175401194@qq.com>
// +----------------------------------------------------------------------

package cn.qhy.common.aspect;

/**
 * 自定义操作日志切面处理类
 */
// @Slf4j
// @Aspect
// @Component
// public class LogAspect {
//
//     // 配置织入点
//     @Pointcut("@annotation(cn.qhy.goods.annotation.Log)")
//     public void logPointCut() {
//     }
//
//     /**
//      * 处理完请求后执行
//      *
//      * @param joinPoint 切点
//      */
//     @AfterReturning(pointcut = "logPointCut()", returning = "jsonResult")
//     public void doAfterReturning(JoinPoint joinPoint, Object jsonResult) {
//         handleLog(joinPoint, null, jsonResult);
//     }
//
//     /**
//      * 拦截异常操作
//      *
//      * @param joinPoint 切点
//      * @param e         异常
//      */
//     @AfterThrowing(value = "logPointCut()", throwing = "e")
//     public void doAfterThrowing(JoinPoint joinPoint, Exception e) {
//         handleLog(joinPoint, e, null);
//     }
//
//     protected void handleLog(final JoinPoint joinPoint, final Exception e, Object jsonResult) {
//         try {
//             // 获得注解
//             Log controllerLog = getAnnotationLog(joinPoint);
//             if (controllerLog == null) {
//                 return;
//             }
//
//             // *========数据库日志=========*//
//             OperLog operLog = new OperLog();
//             User user = ShiroUtils.getUserInfo();
//             operLog.setOperName(StringUtils.isNull(user) ? "系统异常" : user.getUsername());
//             operLog.setCreateUser(user.getId());
//             operLog.setStatus(LogStatus.SUCCESS.ordinal());
//             // 请求的地址
//             String ip = IpUtils.getIpAddr(ServletUtils.getRequest());
//             operLog.setOperIp(ip);
//             // 返回参数
//             operLog.setJsonResult(JSON.toJSONString(jsonResult));
//             operLog.setOperUrl(ServletUtils.getRequest().getRequestURI());
//             if (e != null) {
//                 operLog.setStatus(LogStatus.FAIL.ordinal());
//                 operLog.setNote(StringUtils.substring(e.getMessage(), 0, 2000));
//             }
//             // 设置方法名称
//             String className = joinPoint.getTarget().getClass().getName();
//             String methodName = joinPoint.getSignature().getName();
//             operLog.setOperMethod(className + "." + methodName + "()");
//             // 设置请求方式
//             operLog.setRequestMethod(ServletUtils.getRequest().getMethod());
//             // 处理设置注解上的参数
//             getControllerMethodDescription(joinPoint, controllerLog, operLog);
//             // 保存数据库
//             AsyncManager.me().execute(AsyncFactory.recordOper(operLog));
//         } catch (Exception exp) {
//             // 记录本地异常日志
//             log.error("==前置通知异常==");
//             log.error("异常信息:{}", exp.getMessage());
//             exp.printStackTrace();
//         }
//     }
//
//     /**
//      * 获取注解中对方法的描述信息 用于Controller层注解
//      *
//      * @param log     日志
//      * @param operLog 操作日志
//      * @throws Exception
//      */
//     public void getControllerMethodDescription(JoinPoint joinPoint, Log log, OperLog operLog) throws Exception {
//         // 设置action动作
//         operLog.setLogType(log.logType().ordinal());
//         // 设置标题
//         operLog.setTitle(log.title());
//         // 设置操作人类别
//         operLog.setOperType(log.operType().ordinal());
//         // 是否需要保存request，参数和值
//         if (log.isSaveRequestData()) {
//             // 获取参数的信息，传入到数据库中。
//             setRequestValue(joinPoint, operLog);
//         }
//     }
//
//     /**
//      * 获取请求的参数，放到log中
//      *
//      * @param operLog 操作日志
//      * @throws Exception 异常
//      */
//     private void setRequestValue(JoinPoint joinPoint, OperLog operLog) throws Exception {
//         String requestMethod = operLog.getRequestMethod();
//         if (HttpMethod.PUT.name().equals(requestMethod) || HttpMethod.POST.name().equals(requestMethod)) {
//             String params = argsArrayToString(joinPoint.getArgs());
//             operLog.setOperParam(StringUtils.substring(params, 0, 2000));
//         } else {
//             Map<?, ?> paramsMap = (Map<?, ?>) ServletUtils.getRequest().getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
//             operLog.setOperParam(StringUtils.substring(paramsMap.toString(), 0, 2000));
//         }
//     }
//
//     /**
//      * 是否存在注解，如果存在就获取
//      */
//     private Log getAnnotationLog(JoinPoint joinPoint) throws Exception {
//         Signature signature = joinPoint.getSignature();
//         MethodSignature methodSignature = (MethodSignature) signature;
//         Method method = methodSignature.getMethod();
//
//         if (method != null) {
//             return method.getAnnotation(Log.class);
//         }
//         return null;
//     }
//
//     /**
//      * 参数拼装
//      */
//     private String argsArrayToString(Object[] paramsArray) {
//         String params = "";
//         if (paramsArray != null && paramsArray.length > 0) {
//             for (int i = 0; i < paramsArray.length; i++) {
//                 if (!isFilterObject(paramsArray[i])) {
//                     Object jsonObj = JSON.toJSON(paramsArray[i]);
//                     params += jsonObj.toString() + " ";
//                 }
//             }
//         }
//         return params.trim();
//     }
//
//     /**
//      * 判断是否需要过滤的对象。
//      *
//      * @param o 对象信息。
//      * @return 如果是需要过滤的对象，则返回true；否则返回false。
//      */
//     public boolean isFilterObject(final Object o) {
//         return o instanceof MultipartFile || o instanceof HttpServletRequest || o instanceof HttpServletResponse;
//     }
//
// }
